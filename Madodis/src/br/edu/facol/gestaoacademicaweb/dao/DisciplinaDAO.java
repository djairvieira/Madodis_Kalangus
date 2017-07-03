package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;

public interface DisciplinaDAO extends BaseDao<Disciplina> {
	
	List<Disciplina> getByProfessorId(int id);
	
}
