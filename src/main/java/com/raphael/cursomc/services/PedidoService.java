package com.raphael.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raphael.cursomc.domain.ItemPedido;
import com.raphael.cursomc.domain.PagamentoComBoleto;
import com.raphael.cursomc.domain.Pedido;
import com.raphael.cursomc.domain.enums.EstadoPagamento;
import com.raphael.cursomc.repositories.ItemPedidoRepository;
import com.raphael.cursomc.repositories.PagamentoRepository;
import com.raphael.cursomc.repositories.PedidoRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundExceptions;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id
					+ " , Tipo: " + Pedido.class.getName());
		}
		return obj;
	}

	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date());
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if(pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,pedido.getInstante());
		}
		pedido = repo.save(pedido);
		pagamentoRepository.save(pedido.getPagamento());
		for(ItemPedido ip: pedido.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(pedido);			
		}
		itemPedidoRepository.save(pedido.getItens());
		return pedido;
	}
	
}
