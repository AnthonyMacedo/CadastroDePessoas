package com.cadastropessoas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cadastropessoas.model.Pessoa;
import com.cadastropessoas.model.dto.PessoaPesquisaDto;
import com.cadastropessoas.repository.PessoaRepository;
import com.cadastropessoas.util.jpa.Transactional;

public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.salvar(pessoa);
	}
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.buscarPorId(Pessoa.class, id);
	}

	public List<Pessoa> buscarTodos() {
		return pessoaRepository.buscarTodos(Pessoa.class);
	}

	@Transactional
	public void removerPessoa(Pessoa pessoa) {
		try {
			Pessoa pessoaAtual = this.buscarPorId(pessoa.getId());
			
			pessoaRepository.remover(pessoaAtual);
		} catch (Exception e) {
		}
	}

	public List<Pessoa> pesquisar(PessoaPesquisaDto pessoaPesquisaDto) {
		return pessoaRepository.pesquisar(pessoaPesquisaDto, 15);
	}

}
