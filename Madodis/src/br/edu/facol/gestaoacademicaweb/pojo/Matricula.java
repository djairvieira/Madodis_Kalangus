package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_MATRICULA")
public class Matricula extends BaseObject {

	@OneToOne(fetch=FetchType.EAGER)
	private Aluno aluno;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Turma turma;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "[id: "+ getId() +", aluno: "+ getAluno() +", turma: "+ getTurma() +"]";
	}
	
}
