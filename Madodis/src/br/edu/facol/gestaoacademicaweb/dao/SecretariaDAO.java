package br.edu.facol.gestaoacademicaweb.dao;

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;

public interface SecretariaDAO extends BaseDao<Secretaria> {
	
	public Secretaria autenticar(String matricula, String senha);
	public Secretaria autenticar(String matricula, String cpf, String rg);
	public Secretaria getByEmail(String email);
}
