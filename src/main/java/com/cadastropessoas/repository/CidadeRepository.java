package com.cadastropessoas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cadastropessoas.model.Cidade;

public class CidadeRepository extends GenericRepository<Cidade, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	

	public List<Cidade> buscarTodasPorUf(String uf) {

		TypedQuery<Cidade> query = manager.createQuery("from Cidade c "
				+ "where c.estado.uf = :uf ", Cidade.class);

		query.setParameter("uf", uf);

		return query.getResultList();
	}
	
	public List<Cidade> buscarTodos(){
		return manager.createQuery("from Cidade c join fetch c.estado e ", Cidade.class).getResultList();
	}
	
}
