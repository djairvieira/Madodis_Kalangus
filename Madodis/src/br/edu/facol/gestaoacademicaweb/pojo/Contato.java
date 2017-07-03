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

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="TB_CONTATO")
public class Contato extends BaseObject {

	@NotNull(message="Nome não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME")
	private String nome;
	
	@NotNull(message="Email não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Email deve ter entre 1 e 100 caracteres.")
	@Email(message="Email em formato não aceito.")
	@Column(name="EMAIL")
	private String email;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Telefone telefone;
	
	@NotNull(message="Descrição não pode ser nulo ou vazio.")
	@Size(min=20, max=250, message="Descrição deve ter entre 20 e 250 caracteres.")
	@Column(name="MENSAGEM")
	private String mensagem;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Instituicao instituicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "Curso [id=" + getId() + ", nome=" + nome + "]";
	}
	
}
