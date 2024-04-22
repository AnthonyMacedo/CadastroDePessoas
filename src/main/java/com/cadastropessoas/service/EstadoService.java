package com.cadastropessoas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cadastropessoas.model.Estado;
import com.cadastropessoas.repository.EstadoRepository;

public class EstadoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoRepository estadoRepository;
	
	
	public List<Estado> buscarTodos(){
		return estadoRepository.buscarTodos();
	}

	public Estado buscarPorId(Long id) {
		return estadoRepository.buscarPorId(Estado.class, id);
	}
	
}
