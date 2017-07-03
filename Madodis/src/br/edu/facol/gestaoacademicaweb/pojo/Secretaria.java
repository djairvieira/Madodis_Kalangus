package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_SECRETARIA")
public class Secretaria extends Funcionario {
	
	public Secretaria() {
		super(); 
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
