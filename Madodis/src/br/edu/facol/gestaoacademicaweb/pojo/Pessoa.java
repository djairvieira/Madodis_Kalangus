package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Pessoa extends BaseObject {

	@NotNull(message="Nome não pode ser nulo.")
	@Size(min=1, max=100, message="Nome deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SEXO")
	@Enumerated(value=EnumType.ORDINAL)
	private Sexo sexo;
	
	@NotNull(message="Data de nascimento não pode ser nulo.")
	@Size(min=10, max=10, message="Data de nascimento deve ter 10 caracteres.")
	@Column(name="DATA_NASCIMENTO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataNascimento;
	
	@NotNull(message="Nome do pai não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome do pai deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME_PAI")
	private String nomePai;
	
	@NotNull(message="Nome da mãe não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome da mãe deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME_MAE")
	private String nomeMae;
	
	@NotNull(message="Cpf não pode ser nulo ou vazio.")
	@Size(min=14, max=14, message="Cpf deve ter 14 caracteres. Ex: 000.000.000-00")
	@Column(name="CPF")
	private String cpf;
	
	@NotNull(message="RG não pode ser nulo ou vazio.")
	@Size(min=7, max=20, message="RG deve ter entre 7 e 20 caracteres.")
	@Column(name="RG")
	private String rg;
	
	@NotNull(message="Orgão Expedidor não pode ser nulo ou vazio.")
	@Size(min=3, max=10, message="Orgão Expedidor deve ter entre 3 e 10 caracteres.")
	@Column(name="RG_ORGAO_EXPEDIDOR")
	private String rgOrgaoExpedidor;
	
	@NotNull(message="Titulo não pode ser nulo ou vazio.")
	@Size(min=12, max=12, message="Titulo deve ter 12 caracteres. Ex: 081645530884")
	@Column(name="TITULO_ELEITORAL")
	private String tituloEleitoral;
	
	@NotNull(message="Nacionalidade não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nacionalidade deve ter entre 1 e 100 caracteres.")
	@Column(name="NACIONALIDADE")
	private String nacionalidade;
	
	@NotNull(message="Naturalidade não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Naturalidade deve ter entre 1 e 100 caracteres.")
	@Column(name="NATURALIDADE")
	private String naturalidade;
	
	@NotNull(message="Email não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Email deve ter entre 1 e 100 caracteres.")
	@Email(message="Email em formato não aceito.")
	@Column(name="EMAIL")
	private String email;
	
	@NotNull(message="Senha não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Senha deve ter entre 1 e 100 caracteres.")
	@Column(name="SENHA")
	private String senha;
	
	@NotNull(message="Matricula não pode ser nulo ou vazio.")
	@Size(min=3, max=10, message="Matricula deve ter entre 3 e 10 caracteres.")
	@Column(name="MATRICULA")
	private String matricula;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Instituicao instituicao;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Endereco endereco;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Telefone telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgaoExpedidor() {
		return rgOrgaoExpedidor;
	}

	public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
		this.rgOrgaoExpedidor = rgOrgaoExpedidor;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
