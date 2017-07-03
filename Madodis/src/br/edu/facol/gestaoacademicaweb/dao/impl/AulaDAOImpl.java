package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.AulaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;

@Repository
public class AulaDAOImpl extends BaseDaoImpl<Aula> implements AulaDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aula> listarTodos(Professor professor) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.professor.id = :").append(instId);
		
		List<Aula> list = null;
		
		try {
			list = (List<Aula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(instId, professor.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aula> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.professor.instituicao.id = :").append(instId);
		
		List<Aula> list = null;
		
		try {
			list = (List<Aula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(instId, instituicao.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
}
