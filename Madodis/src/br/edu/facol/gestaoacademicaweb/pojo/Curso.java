package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_CURSO")
public class Curso extends BaseObject {

	@NotNull(message="Nome não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Nome deve ter entre 1 e 100 caracteres.")
	@Column(name="NOME")
	private String nome;
	
	@NotNull(message="Sigla não pode ser nulo ou vazio.")
	@Size(min=1, max=100, message="Sigla deve ter entre 1 e 100 caracteres.")
	@Column(name="SIGLA")
	private String sigla;
	
	@NotNull(message="Sigla não pode ser nulo ou vazio.")
	@Size(min=3, max=50, message="Sigla deve ter entre 3 e 50 caracteres.")
	@Column(name="CODIGO_CURSO_MEC")
	private String codigoCursoMec;
	
	@NotNull(message="Descrição não pode ser nulo ou vazio.")
	@Size(min=50, max=250, message="Descrição  deve ter entre 50 e 250 caracteres.")
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Max(value=10, message="A quantidade de periodos máximo é 10")
	@Min(value=1, message="A quantidade de periodos minimo é 1")
	@Column(name="PERIODOS")
	private int periodos;
	
	@NotNull(message="Area não pode ser nulo ou vazio.")
	@Size(min=3, max=50, message="Area deve ter entre 3 e 50 caracteres.")
	@Column(name="AREA")
	private String area;
	
	@NotNull(message="Tipo de ensino não pode ser nulo ou vazio.")
	@Enumerated(value=EnumType.ORDINAL)
	@Column(name="TIPO_ENSINO")
	private TipoEnsino tipoEnsino;
	
	@NotNull(message="Data de criaação não pode ser nulo ou vazio.")
	@Size(min=6, max=15, message="Data de criação deve ter entre 6 e 15 caracteres.")
	@Column(name="DATA_CRIACAO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataCriacao;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Instituicao instituicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodigoCursoMec() {
		return codigoCursoMec;
	}

	public void setCodigoCursoMec(String codigoCursoMec) {
		this.codigoCursoMec = codigoCursoMec;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPeriodos() {
		return periodos;
	}

	public void setPeriodos(int periodos) {
		this.periodos = periodos;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public TipoEnsino getTipoEnsino() {
		return tipoEnsino;
	}

	public void setTipoEnsino(TipoEnsino tipoEnsino) {
		this.tipoEnsino = tipoEnsino;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "Curso [id=" + getId() + ", nome=" + nome + "]";
	}
	
}
