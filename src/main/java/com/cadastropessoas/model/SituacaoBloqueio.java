package com.cadastropessoas.model;

public enum SituacaoBloqueio {

	BLOQUEADO("Bloqueado"),
	DESBLOQUEADO("Desbloqueado");

	private String descricao;

	SituacaoBloqueio(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
