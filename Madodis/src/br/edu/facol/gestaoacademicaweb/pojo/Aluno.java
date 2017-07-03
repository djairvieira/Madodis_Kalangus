package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
public class Aluno extends Pessoa {
	
	@Override
	public String toString() {
		return "Aluno [id=" + getId() + ", nome=" + getNome() + ", matricula=" + getMatricula() + "]";
	}
	
}
