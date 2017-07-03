package br.edu.facol.gestaoacademicaweb.dao;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

public interface AlunoDAO extends BaseDao<Aluno> {
	
	public Aluno autenticar(String matricula, String senha);
	public Aluno autenticar(String matricula, String cpf, String rg);
	public Aluno getByEmail(String email);
	
}
