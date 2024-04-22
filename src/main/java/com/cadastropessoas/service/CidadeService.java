package com.cadastropessoas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cadastropessoas.model.Cidade;
import com.cadastropessoas.repository.CidadeRepository;

public class CidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CidadeRepository cidadeRepository;
	
	
	public List<Cidade> buscarTodos(){
		return cidadeRepository.buscarTodos();
	}
	
	public List<Cidade> buscarTodasPorUf(String uf){
		return cidadeRepository.buscarTodasPorUf(uf);
	}

	public Cidade buscarPorId(Long id) {
		return cidadeRepository.buscarPorId(Cidade.class, id);
	}
	
	
}
