package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO_FREQUENCIA")
public class AlunoFrequencia extends BaseObject {

	@OneToOne(fetch=FetchType.EAGER)
	private Aluno aluno;
	
	@Column(name="PRESENTE")
	private boolean presente;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	@Override
	public String toString() {
		return "AlunoFrequencia[id = "+ getId() +", aluno = "+ aluno.getNome() +"]";
	}

}
