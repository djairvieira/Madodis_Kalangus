package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="DIARIO_DE_CLASSE")
public class DiarioDeClasse extends BaseObject {

	@OneToOne(fetch=FetchType.EAGER)
	private Aula aula;
	
	@NotNull(message="Conteúdoo programado não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Conteúdo programado nÃ£o deve ter entre 1 e 100 caracteres.")
	@Column(name="CONTEUDO_PROGRAMADO")
	private String conteudoProgramado;
	
	@NotNull(message="ConteÃºdo realizado não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Conteúdo realizado não deve ter entre 1 e 100 caracteres.")
	@Column(name="CONTEUDO_REALIZADO")
	private String conteudoRealizado;

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getConteudoProgramado() {
		return conteudoProgramado;
	}

	public void setConteudoProgramado(String conteudoProgramado) {
		this.conteudoProgramado = conteudoProgramado;
	}

	public String getConteudoRealizado() {
		return conteudoRealizado;
	}

	public void setConteudoRealizado(String conteudoRealizado) {
		this.conteudoRealizado = conteudoRealizado;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
