package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Funcionario extends Pessoa {

	@NotNull(message="Numero CTPS não pode ser nulo ou vazio.")
	@Size(min=4, max=20, message="Numero CTPS deve ter entre 4 e 20 caracteres.")
	@Column(name="CTPS_NUMERO")
	private String ctpsNumero;
	
	@NotNull(message="Data de Expedição não pode ser nulo ou vazio.")
	@Size(min=6, max=15, message="Data de Expedição deve ter entre 6 e 15 caracteres.")
	@Column(name="CTPS_DATA_EXPEDICAO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String ctpsDataExpedicao;

	public String getCtpsNumero() {
		return ctpsNumero;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public String getCtpsDataExpedicao() {
		return ctpsDataExpedicao;
	}

	public void setCtpsDataExpedicao(String ctpsDataExpedicao) {
		this.ctpsDataExpedicao = ctpsDataExpedicao;
	}
	
	public abstract boolean temAcesso(String menu);

}
