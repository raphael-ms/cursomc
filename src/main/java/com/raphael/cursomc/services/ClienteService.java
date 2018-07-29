package com.raphael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Cliente;
import com.raphael.cursomc.repositories.ClienteRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundExceptions;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id
					+ " , Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
}
