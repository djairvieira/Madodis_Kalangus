package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="TB_ALUNO_PROVA")
public class AlunoProva extends BaseObject {

	@OneToOne(fetch=FetchType.EAGER)
	private Aluno aluno;
	
	@Min(value=0, message="O valor minimo para a nota é 0.")
	@Max(value=10, message="O valor maximo para a nota é 10")
	@Column(name="NOTA")
	private float nota;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "AlunoProva[id = "+ getId() +", aluno = "+ aluno.getNome() +"]";
	}

}
