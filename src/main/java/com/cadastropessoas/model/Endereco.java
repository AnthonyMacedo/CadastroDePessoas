package com.cadastropessoas.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "sch_desafio")
public class Endereco extends AbstractEntityBase {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 120)
	private String logradouro;

	@Column(length = 20)
	private String numero;

	@Column(length = 60)
	private String bairro;

	@Column(length = 120)
	private String complemento;

	@Column(length = 10)
	private String cep;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_endereco_cidade_id"))
	private Cidade cidade;

	@Column(length = 2)
	private String uf;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "fk_endereco_pessoa_id"))
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void iniciar() {
		this.cidade = new Cidade();
		this.cidade.iniciar();
	}
	
	public void copiarPropriedades(Endereco endereco) {
		this.setId(endereco.getId());
		this.setCidade(endereco.getCidade());
		this.setBairro(endereco.getBairro());
		this.setCep(endereco.getCep());
		this.setComplemento(endereco.getComplemento());
		this.setLogradouro(endereco.getLogradouro());
		this.setNumero(endereco.getNumero());
		this.setPessoa(endereco.getPessoa());
		this.setUf(endereco.getUf());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
