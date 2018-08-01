package com.raphael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Pedido;
import com.raphael.cursomc.repositories.PedidoRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundExceptions;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id
					+ " , Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
}
