package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_DISCIPLINA")
public class Disciplina extends BaseObject {

	@NotNull(message="Nome não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME")
	private String nome;
	
	@NotNull(message="Sigla não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Sigla deve ter entre 1 e 100 caracteres.")
	@Column(name="SIGLA")
	private String sigla;
	
	@Max(value=40, message="Os creditos máximos são 40 horas")
	@Min(value=20, message="Os creditos minimos são 20 horas")
	@Column(name="CREDITOS")
	private int creditos;
	
	@Max(value=120, message="A carga horaria máxima são 120 horas")
	@Min(value=35, message="A carga horaria minima são 35 horas")
	@Column(name="CARGA_HORARIA")
	private int cargaHoraria;
	
	@Max(value=10, message="O modulo pertencente máximos é 10")
	@Min(value=1, message="O modulo pertencente minimo é 1")
	@Column(name="MODULO_PERTENCENTE")
	private int moduloPertencente;
	
	@NotNull(message="Descrição nãoo pode ser nulo ou vazio.")
	@Size(min=15, max=250, message="Descriçãoo deve ter entre 15 e 250 caracteres.")
	@Column(name="DESCRICAO")
	private String descricao;
	
	@NotNull(message="Requisitos não pode ser nulo ou vazio.")
	@Size(min=10, max=250, message="Requisitos deve ter entre 10 e 250 caracteres.")
	@Column(name="REQUISITOS")
	private String requisitos;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Professor professor;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private PlanoDeEnsino planoDeEnsino;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public PlanoDeEnsino getPlanoDeEnsino() {
		return planoDeEnsino;
	}

	public void setPlanoDeEnsino(PlanoDeEnsino planoDeEnsino) {
		this.planoDeEnsino = planoDeEnsino;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getModuloPertencente() {
		return moduloPertencente;
	}

	public void setModuloPertencente(int moduloPertencente) {
		this.moduloPertencente = moduloPertencente;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return " Disciplina [ id = " + getId() + ", nome = " + getNome() + "]";
	}

}
