package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.TipoEnsino;

public interface CursoDAO extends BaseDao<Curso> {
	
	List<Curso> listarTodos(Instituicao instituicao, TipoEnsino tipo);
	
}
