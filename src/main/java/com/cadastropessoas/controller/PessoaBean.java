package com.cadastropessoas.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cadastropessoas.model.Cidade;
import com.cadastropessoas.model.Endereco;
import com.cadastropessoas.model.Estado;
import com.cadastropessoas.model.Pessoa;
import com.cadastropessoas.model.TipoSexo;
import com.cadastropessoas.model.dto.PessoaPesquisaDto;
import com.cadastropessoas.service.CidadeService;
import com.cadastropessoas.service.EnderecoService;
import com.cadastropessoas.service.EstadoService;
import com.cadastropessoas.service.PessoaService;
import com.cadastropessoas.util.NegocioException;

@Named
@ViewScoped
public class PessoaBean extends BaseManagedBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaService pessoaService;
	@Inject
	private EnderecoService enderecoService;
	@Inject
	private CidadeService cidadeService;
	@Inject
	private EstadoService estadoService;

	private Pessoa pessoa;
	private Endereco enderecoInput;
	private PessoaPesquisaDto pessoaPesquisaDto;

	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public void inicializar() {
		if (this.pessoa == null) {
			this.limpar();
		}

		this.enderecoInput = new Endereco();
		this.enderecoInput.iniciar();

		this.cidades = cidadeService.buscarTodos();
		this.estados = estadoService.buscarTodos();
	}

	public void carregarTodos() {

		if (pessoas == null) {
			this.pessoas = pessoaService.buscarTodos();
		}
		
		this.pessoaPesquisaDto = new PessoaPesquisaDto();
	}

	public void salvar() throws NegocioException {

		try {
			if (this.pessoa != null) {
				pessoaService.salvar(pessoa);

				super.addInfoMessage("Cadastro registrado com sucesso.");
			}
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		this.limpar();
	}

	public void limpar() {

		this.pessoa = new Pessoa();
		this.pessoa.iniciar();

	}

	public void adicionarEndereco(Endereco endereco) {

		int index = -1;

		if (pessoa.getId() != null) {
			if (endereco.getId() != null) {
				Endereco enderecoAtual = enderecoService.buscarPorId(endereco.getId());
				enderecoAtual.copiarPropriedades(endereco);
				index = this.pessoa.getEnderecos().indexOf(enderecoAtual);

				this.pessoa.getEnderecos().get(index).copiarPropriedades(enderecoAtual);
			} else {
				endereco.setPessoa(pessoa);
				this.enderecoService.salvar(endereco);

				this.pessoa.setEnderecos(enderecoService.buscarPorPessoaId(endereco.getPessoa().getId()));
			}

		} else {
			index = this.pessoa.getEnderecos().indexOf(endereco);

			if (index < 0) {
				endereco.setPessoa(pessoa);
				if (this.pessoa != null && endereco != null) {
					this.pessoa.getEnderecos().add(endereco);
				}
			} else {
				this.pessoa.getEnderecos().get(index).copiarPropriedades(endereco);
			}

		}
	
		this.enderecoInput = new Endereco();
		super.executarScript("PF('dlg-endereco').hide()");
	}

	public void abrirDialogEndereco() {
//		this.enderecoInput.setCidade(new Cidade());
//		this.enderecoInput.getCidade().setEstado(new Estado());

		super.executarScript("PF('dlg-endereco').show()");
	}

	public void editarEndereco(Endereco endereco) {
		boolean isEnderecoNovo = endereco.getId() == null;

		if (isEnderecoNovo) {
			this.enderecoInput.copiarPropriedades(endereco);
		} else {
			this.enderecoInput = enderecoService.buscarPorId(endereco.getId());

			this.enderecoInput.setCidade(cidadeService.buscarPorId(endereco.getCidade().getId()));
			this.enderecoInput.getCidade()
					.setEstado(estadoService.buscarPorId(endereco.getCidade().getEstado().getId()));
		}

		this.abrirDialogEndereco();
	}

	public void removerEndereco(Endereco endereco) throws NegocioException {
		try {
			if (endereco.getId()!= null) {
				Endereco enderecoAtual = enderecoService.buscarPorId(endereco.getId());

//				enderecoService.removerEndereco(enderecoAtual);
				
				this.pessoa.getEnderecos().remove(enderecoAtual);
				
			} else {
				this.pessoa.getEnderecos().remove(endereco);
			}
			
		} catch (Exception e) {
			super.addErrorMessage("Falha ao removero  endereço.");
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void removerPessoa(Pessoa pessoa) {
			
		try {
			this.pessoaService.removerPessoa(pessoa);
			
			this.pessoas = pessoaService.buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		super.addInfoMessage("Registro removido com sucesso.");
	}
	
	public void pesquisar(){
		
		this.pessoas = this.pessoaService.pesquisar(this.pessoaPesquisaDto);
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public TipoSexo[] getSexoValues() {
		return TipoSexo.values();
	}

	public Endereco getEnderecoInput() {
		return enderecoInput;
	}

	public void setEnderecoInput(Endereco enderecoInput) {
		this.enderecoInput = enderecoInput;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public PessoaPesquisaDto getPessoaPesquisaDto() {
		return pessoaPesquisaDto;
	}

	public void setPessoaPesquisaDto(PessoaPesquisaDto pessoaPesquisaDto) {
		this.pessoaPesquisaDto = pessoaPesquisaDto;
	}

}
