package com.cadastropessoas.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cadastropessoas.model.Endereco;
import com.cadastropessoas.model.dto.EnderecoPesquisaDto;
import com.cadastropessoas.service.EnderecoService;

@Named
@ViewScoped
public class EnderecoBean extends BaseManagedBean {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EnderecoService enderecoService;
	
	private EnderecoPesquisaDto enderecoPesquisaDto;
	
	private List<Endereco> enderecos;
	
	public void carregarTodos() {
		this.enderecoPesquisaDto = new EnderecoPesquisaDto();
	}

	public void pesquisar() {
		this.enderecos = enderecoService.pesquisar(this.enderecoPesquisaDto);
	}
	
	public EnderecoService getEnderecoService() {
		return enderecoService;
	}

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	public EnderecoPesquisaDto getEnderecoPesquisaDto() {
		return enderecoPesquisaDto;
	}

	public void setEnderecoPesquisaDto(EnderecoPesquisaDto enderecoPesquisaDto) {
		this.enderecoPesquisaDto = enderecoPesquisaDto;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	
	
}
