package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.TurmaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

@Repository
public class TurmaDAOImpl extends BaseDaoImpl<Turma> implements TurmaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select t from ").append(this.getPersistentClass().getName())
				.append(" t where t.disciplina.professor.instituicao.id = :").append(instId);
		
		List<Turma> list = null;
		
		try {
			list = (List<Turma>)
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
	public List<Turma> getByProfessorId(int id) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select t from ").append(this.getPersistentClass().getName())
				.append(" t where t.disciplina.professor.id = :").append(idParam);
		
		List<Turma> list = null;
		
		try {
			list = (List<Turma>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, id)
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
}
