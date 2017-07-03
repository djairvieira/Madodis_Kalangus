package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.DisciplinaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

@Repository
public class DisciplinaDAOImpl extends BaseDaoImpl<Disciplina> implements DisciplinaDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select d from ").append(this.getPersistentClass().getName())
				.append(" d where d.professor.instituicao.id = :").append(instId);
		
		List<Disciplina> list = null;
		
		try {
			list = (List<Disciplina>)
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
	public List<Disciplina> getByProfessorId(int id) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select d from ").append(this.getPersistentClass().getName())
				.append(" d where d.professor.id = :").append(idParam);
		
		List<Disciplina> list = null;
		
		try {
			list = (List<Disciplina>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, id)
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
}
