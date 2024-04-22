package com.cadastropessoas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cadastropessoas.model.Endereco;
import com.cadastropessoas.model.dto.EnderecoPesquisaDto;

public class EnderecoRepository extends GenericRepository<Endereco, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Endereco> buscarTodos() {
		return manager.createQuery("from Endereco", Endereco.class).getResultList();
	}

	public Endereco buscarPorId(Long id) {
		return manager.createQuery("from Endereco e "
				+ "where e.id = :id", Endereco.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	public List<Endereco> buscarPorPessoaId(Long id) {
		return manager.createQuery("from Endereco e where e.pessoa.id = :pessoaId ", Endereco.class).setParameter("pessoaId", id).getResultList();
	}

	public List<Endereco> pesquisar(EnderecoPesquisaDto enderecoPesquisaDto) {
		
		String addFiltros = "";
		
		if (enderecoPesquisaDto != null) {
			if (enderecoPesquisaDto.getNomePessoa() != null && !enderecoPesquisaDto.getNomePessoa().isEmpty()) {
				addFiltros += "and Upper(e.pessoa.nome) like upper(:nome) ";
			}
		}
		
		TypedQuery<Endereco> query = manager.createQuery("from Endereco e "
				+ "where e.id is not null "
				+ addFiltros
				+ "order by e.id ", Endereco.class);
		
		
		if (addFiltros.contains(":nome")) {
			query.setParameter("nome", "%" +enderecoPesquisaDto.getNomePessoa() + "%");
		}
		return query.getResultList();
	}
	
}
