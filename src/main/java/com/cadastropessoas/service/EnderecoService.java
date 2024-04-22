package com.cadastropessoas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cadastropessoas.model.Endereco;
import com.cadastropessoas.model.dto.EnderecoPesquisaDto;
import com.cadastropessoas.repository.EnderecoRepository;
import com.cadastropessoas.util.jpa.Transactional;

public class EnderecoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.salvar(endereco);
	}
 	
	public List<Endereco> buscarTodos(){
		return enderecoRepository.buscarTodos();
	}

	public Endereco buscarPorId(Long id) {
		return enderecoRepository.buscarPorId(id);
	}
	
	public List<Endereco> buscarPorPessoaId(Long id) {
		return enderecoRepository.buscarPorPessoaId(id);
	}

	@Transactional
	public void removerEndereco(Endereco endereco) {
		try {
			enderecoRepository.remover(endereco);
		} catch (Exception e) {
		}
	}

	public List<Endereco> pesquisar(EnderecoPesquisaDto enderecoPesquisaDto) {
		return enderecoRepository.pesquisar(enderecoPesquisaDto);
	}
	
}
