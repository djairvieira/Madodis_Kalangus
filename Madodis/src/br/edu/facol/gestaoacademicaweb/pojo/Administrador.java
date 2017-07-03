package br.edu.facol.gestaoacademicaweb.pojo;

public class Administrador {

	private String nome;
	private String senha;
	private Instituicao instituicao;
	
	private Administrador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public static Administrador getInstance() {
		return new Administrador("admin", "admin");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
