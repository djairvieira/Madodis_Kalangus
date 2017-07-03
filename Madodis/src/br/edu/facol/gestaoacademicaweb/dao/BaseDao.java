package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.BaseObject;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface BaseDao<T extends BaseObject> {

	void salvar(T entity);
	
	void atualizar(T entity);
	
	void remover(T entity);
	
	boolean remover(int id);
	
	T getById(int id);
	
	List<T> getByFieldName(int id, String fieldName, String fieldValue);
	
	List<T> listarTodos();
	
	List<T> listarTodos(Instituicao instituicao);
	
}
