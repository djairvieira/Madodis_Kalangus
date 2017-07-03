package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.CursoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.TipoEnsino;

@Repository
public class CursoDAOImpl extends BaseDaoImpl<Curso> implements CursoDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select c from ").append(this.getPersistentClass().getName())
				.append(" c where c.instituicao.id = :").append(instId);
		
		List<Curso> list = null;
		
		try {
			list = (List<Curso>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(instId, instituicao.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos(Instituicao instituicao, TipoEnsino tipo) {
		final String instId = "id";
		final String tipoParam = "tipo";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select c from ").append(this.getPersistentClass().getName())
				.append(" c where c.instituicao.id = :").append(instId)
				.append(" and c.tipoEnsino = :").append(tipoParam);
		
		List<Curso> list = null;
		
		try {
			list = (List<Curso>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(instId, instituicao.getId())
					.setParameter(tipoParam, tipo)
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
}
