package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_AULA")
public class Aula extends BaseObject {

	@NotNull(message="Assunto n�o pode ser nulo ou vazio.")
	@Size(min=5, max=100, message="Assunto deve ter entre 5 e 100 caracteres.")
	@Column(name="ASSUNTO")
	private String assunto;
	
	@NotNull(message="Data de aula n�o pode ser nulo ou vazio.")
	@Size(min=10, max=10, message="Data de aula deve ter 10 caracteres.")
	@Column(name="DATA_AULA")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataAula;
	
	@NotNull(message="Tipo de aula n�o pode ser nulo ou vazio.")
	@Column(name="TIPO_AULA")
	@Enumerated(value=EnumType.ORDINAL)
	private TipoDeAula tipoDeAula;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Turma turma;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Professor professor;
	
	@OneToMany(mappedBy = "aula", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<AulaArquivo> aulaArquivos = new HashSet<AulaArquivo>();
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDataAula() {
		return dataAula;
	}

	public TipoDeAula getTipoDeAula() {
		return tipoDeAula;
	}

	public void setTipoDeAula(TipoDeAula tipoDeAula) {
		this.tipoDeAula = tipoDeAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}

	@Override
	public String toString() {
		return "Aula [ id = " + getId() + ", assunto = " + getAssunto() + "]";
	}

	public Set<AulaArquivo> getAulaArquivos() {
		return aulaArquivos;
	}

	public void setAulaArquivos(Set<AulaArquivo> aulaArquivos) {
		this.aulaArquivos = aulaArquivos;
	}

}
