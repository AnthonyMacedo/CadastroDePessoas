package com.cadastropessoas.model.dto;

import java.io.Serializable;

public class EnderecoPesquisaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomePessoa;

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

}
