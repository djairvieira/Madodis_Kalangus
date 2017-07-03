package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FREQUENCIA")
public class Frequencia extends BaseObject {

	@OneToOne(fetch=FetchType.EAGER)
	private Aula aula;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<AlunoFrequencia> frequencias;

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public List<AlunoFrequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<AlunoFrequencia> frequencias) {
		this.frequencias = frequencias;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
