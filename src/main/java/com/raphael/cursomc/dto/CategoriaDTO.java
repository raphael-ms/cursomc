package com.raphael.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.raphael.cursomc.domain.Categoria;

public class CategoriaDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message= "Preenchimento Obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	

	public CategoriaDTO() {
	}


	public Integer getId() {
		return id;
	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
