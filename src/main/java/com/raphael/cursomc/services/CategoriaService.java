package com.raphael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Categoria;
import com.raphael.cursomc.repositories.CategoriaRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundExceptions;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id
					+ " , Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
}
