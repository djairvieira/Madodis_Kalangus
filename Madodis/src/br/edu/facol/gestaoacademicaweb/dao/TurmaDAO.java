package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface TurmaDAO extends BaseDao<Turma> {
	
	public List<Turma> getByProfessorId(int id);
	
}
