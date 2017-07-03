package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_COORDENADOR")
public class Coordenador extends Funcionario {

	@NotNull(message="Em exercicio n�o pode ser nulo ou vazio.")
	@Column(name="EM_EXERCICIO")
	private boolean emExercicio;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Curso curso;
	
	public Coordenador() {
		super();
	}

	public boolean isEmExercicio() {
		return emExercicio;
	}

	public void setEmExercicio(boolean emExercicio) {
		this.emExercicio = emExercicio;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public boolean temAcesso(String menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
