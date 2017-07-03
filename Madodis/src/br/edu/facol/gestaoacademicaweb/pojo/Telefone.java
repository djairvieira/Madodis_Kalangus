package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_TELEFONE")
public class Telefone extends BaseObject {

	@NotNull(message="DDD não pode ser nulo ou vazio.")
	@Size(min=1, message="DDD não pode ser nulo ou vazio.")
	@Column(name="DDD")
	private String ddd;
	
	@NotNull(message="Telefone não pode ser nulo ou vazio.")
	@Size(min=10, max=10, message="Telefone deve ter 10 caracteres.")
	@Column(name="numero")
	private String numero;
	
	public Telefone() {
		super();
	}

	public String getDDD() {
		return ddd;
	}

	public void setDDD(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + ", DDD: " + getDDD() + ", Numero: " + getNumero();
	}
	

}
