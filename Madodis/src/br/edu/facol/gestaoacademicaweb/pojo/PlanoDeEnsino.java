package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_PLANO_ENSINO")
public class PlanoDeEnsino extends BaseObject {

	@NotNull(message="Metodo de aprendizagem não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Metodo de aprendizagem deve ter entre 50 e 250 caracteres.")
	@Column(name="METODO_APRENDIZAGEM")
	private String metodoApredizagem;
	
	@Max(value=80, message="A carga horaria teorica máxima é 80 horas")
	@Min(value=20, message="A carga horaria teorica minima é 20 horas")
	@Column(name="CH_TEORICA")
	private int cargaHorariaTeorica;
	
	@Max(value=80, message="A carga horaria pratica máxima é 80 horas")
	@Min(value=40, message="A carga horaria pratica minima é 40 horas")
	@Column(name="CH_PRATICA")
	private int cargaHorariaPratica;
	
	@NotNull(message="Objetivos não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Objetivos deve ter entre 50 e 250 caracteres.")
	@Column(name="OBJETIVOS")
	private String objetivos;
	
	@NotNull(message="Metodo de avaliação não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Metodo de avaliação deve ter entre 50 e 250 caracteres.")
	@Column(name="METODO_AVALIACAO")
	private String medotoAvaliacao;
	
	@NotNull(message="Bibliografia usada não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Bibliografia usada deve ter entre 50 e 250 caracteres.")
	@Column(name="BIBLIOGRAFIA_USADA")
	private String bibliografiaUsada;
	
	@NotNull(message="Ementa não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Ementa deve ter entre 50 e 250 caracteres.")
	@Column(name="EMENTA")
	private String ementa;
	
	public String getMetodoApredizagem() {
		return metodoApredizagem;
	}

	public void setMetodoApredizagem(String metodoApredizagem) {
		this.metodoApredizagem = metodoApredizagem;
	}

	public int getCargaHorariaTeorica() {
		return cargaHorariaTeorica;
	}

	public void setCargaHorariaTeorica(int cargaHorariaTeorica) {
		this.cargaHorariaTeorica = cargaHorariaTeorica;
	}

	public int getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}

	public void setCargaHorariaPratica(int cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getMedotoAvaliacao() {
		return medotoAvaliacao;
	}

	public void setMedotoAvaliacao(String medotoAvaliacao) {
		this.medotoAvaliacao = medotoAvaliacao;
	}

	public String getBibliografiaUsada() {
		return bibliografiaUsada;
	}

	public void setBibliografiaUsada(String bibliografiaUsada) {
		this.bibliografiaUsada = bibliografiaUsada;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	@Override
	public String toString() {
		return "[ID: " + getId() + ", Metodo de Aprendizagem: " + getMetodoApredizagem() +"]";
	}

	

}
