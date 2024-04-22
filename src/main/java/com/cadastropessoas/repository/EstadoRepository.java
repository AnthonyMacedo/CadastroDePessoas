package com.cadastropessoas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cadastropessoas.model.Estado;

public class EstadoRepository extends GenericRepository<Estado, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Estado> buscarTodos() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

}
