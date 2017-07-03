package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_INSTITUICAO")
public class Instituicao extends BaseObject {
	
	@NotNull(message="Nome fantasia não pode ser nulo ou vazio.")
	@Size(min=2, max=80, message="Nome fantasia deve ter entre 2 e 80 caracteres.")
	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;
	
	@NotNull(message="Nome empresarial não pode ser nulo ou vazio.")
	@Size(min=2, max=80, message="Nome empresarial deve ter entre 2 e 80 caracteres.")
	@Column(name="NOME_EMPRESARIAL")
	private String nomeEmpresarial;
	
	@NotNull(message="CNPJ não pode ser nulo ou vazio.")
	@Size(min=18, max=18, message="O CNPJ deve ter 18 caracteres. Ex: 54.654.654/6546-54")
	@Column(name="CNPJ")
	private String cnpj;
	
	@NotNull(message="Incrição estadual não pode ser nulo ou vazio.")
	@Size(min=1, message="Incrição estadual não pode ser nulo ou vazio.")
	@Column(name="INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Endereco endereco;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Telefone telefone;

	public Instituicao() {
		super();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome Fantasia: " + getNomeFantasia() + ", CNPJ: " + cnpj;
	}

}
