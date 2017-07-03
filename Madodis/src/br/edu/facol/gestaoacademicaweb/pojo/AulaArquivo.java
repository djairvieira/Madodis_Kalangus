package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_AULA_ARQUIVO")
public class AulaArquivo extends BaseObject {

	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="description", length=255)
    private String description;
	
	@Column(name="type", length=100, nullable=true)
    private String type;
     
    @Lob @Basic(fetch = FetchType.EAGER)
    @Column(name="content", nullable=false)
    private byte[] content;
 
    @ManyToOne(optional = false, fetch=FetchType.EAGER)
    @JoinColumn(name = "AULA_ID")
    private Aula aula;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}


}
