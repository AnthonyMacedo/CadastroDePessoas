package com.cadastropessoas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cadastropessoas.model.Pessoa;
import com.cadastropessoas.model.dto.PessoaPesquisaDto;

public class PessoaRepository extends GenericRepository<Pessoa, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public List<Pessoa> pesquisar(PessoaPesquisaDto pessoaPesquisaDto, int maxResult) {
		
		String addFiltro = "";
		
		if (pessoaPesquisaDto != null) {
			if (pessoaPesquisaDto.getNome()!= null && !pessoaPesquisaDto.getNome().isEmpty()) {
				addFiltro += "and upper(c.nome) like upper(:nome) ";
			}
			
			if (pessoaPesquisaDto.getCpf() != null && !pessoaPesquisaDto.getCpf().isEmpty()) {
				addFiltro += "and upper(c.cpf) like upper(:cpf) ";
			}
			
			if (pessoaPesquisaDto.getId() != null) {
				addFiltro += "and c.id = :id ";
			}
		}
		
		TypedQuery<Pessoa> query =  manager.createQuery("select c from Pessoa c "
				+ "where c.id is not null "
				+ addFiltro
				+ "order by c.id desc", Pessoa.class);
		
		if (addFiltro.contains(":nome")) {
			query.setParameter("nome", "%" + pessoaPesquisaDto.getNome() + "%");
		}
		
		if (addFiltro.contains(":cpf")) {
			query.setParameter("cpf","%" + pessoaPesquisaDto.getCpf() + "%");
		}
		
		if (addFiltro.contains(":id")) {
			query.setParameter("id", pessoaPesquisaDto.getId());
		}
		
		query.setMaxResults(maxResult);
		
		return query.getResultList();
	}


}
