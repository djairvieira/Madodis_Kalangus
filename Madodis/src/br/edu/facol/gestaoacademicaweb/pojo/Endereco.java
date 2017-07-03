package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_ENDERECO")
public class Endereco extends BaseObject {

	@NotNull(message="Logradouro não pode ser nulo ou vazio.")
	@Size(min=1, message="Logradouro não pode ser nulo ou vazio.")
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@NotNull(message="Numero não pode ser nulo ou vazio.")
	@Size(min=1, message="Numero não pode ser nulo ou vazio.")
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@NotNull(message="CEP não pode ser nulo ou vazio.")
	@Size(min=1, message="CEP não pode ser nulo ou vazio.")
	@Column(name="cep")
	private String cep;
	
	@NotNull(message="Bairro não pode ser nulo ou vazio.")
	@Size(min=1, message="Bairro não pode ser nulo ou vazio.")
	@Column(name="bairro")
	private String bairro;
	
	@NotNull(message="Cidade não pode ser nulo ou vazio.")
	@Size(min=1, message="Cidade não pode ser nulo ou vazio.")
	@Column(name="cidade")
	private String cidade;
	
	@NotNull(message="Estado não pode ser nulo ou vazio.")
	@Column(name="estado")
	@Enumerated(value=EnumType.ORDINAL)
	private Estado estado;
	
	public Endereco() {
		super();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + ", Logradouro: " + getLogradouro() + ", Numero: " + getNumero();
	}
	

}
