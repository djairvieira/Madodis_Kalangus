package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;

public interface AulaDAO extends BaseDao<Aula> {
	
	public List<Aula> listarTodos(Professor professor);
	
}
