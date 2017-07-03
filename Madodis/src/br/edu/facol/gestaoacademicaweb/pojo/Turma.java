package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_TURMA")
public class Turma extends BaseObject {

	@NotNull(message="Turno não pode ser nulo ou vazio.")
	@Size(min=5, max=40, message="Turno deve ter entre 5 e 40 caracteres.")
	@Column(name="TURNO")
	private String turno;
	
	@NotNull(message="Nome não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME")
	private String nome;
	
	@Min(value=5, message="A quantidade minima de alunos � 5.")
	@Column(name="QTD_MIN_ALUNO")
	private int quantidadeMinimaAluno;
	
	@Max(value=40, message="A quantidade m�xima de aluno � 40.")
	@Column(name="QTD_MAX_ALUNO")
	private int quantidadeMaximaAluno;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Disciplina disciplina;
	
	@NotNull(message="Letra não pode ser nulo ou vazio.")
	@Column(name="TURMA_LETRA")
	@Enumerated(value=EnumType.ORDINAL)
	private TurmaLetra turmaLetra;

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeMinimaAluno() {
		return quantidadeMinimaAluno;
	}

	public void setQuantidadeMinimaAluno(int quantidadeMinimaAluno) {
		this.quantidadeMinimaAluno = quantidadeMinimaAluno;
	}

	public int getQuantidadeMaximaAluno() {
		return quantidadeMaximaAluno;
	}

	public void setQuantidadeMaximaAluno(int quantidadeMaximaAluno) {
		this.quantidadeMaximaAluno = quantidadeMaximaAluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public TurmaLetra getTurmaLetra() {
		return turmaLetra;
	}

	public void setTurmaLetra(TurmaLetra turmaLetra) {
		this.turmaLetra = turmaLetra;
	}
	
	public String getTurmaValues() {
		return nome + " - " + turmaLetra.toString() + " - " + turno;
	}

	@Override
	public String toString() {
		return "[id: "+ getId() +", nome: "+ getNome() +"]";
	}

}
