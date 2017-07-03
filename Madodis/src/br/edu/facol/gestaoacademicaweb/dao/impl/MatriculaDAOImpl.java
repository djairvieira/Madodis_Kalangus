package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.MatriculaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

@Repository
public class MatriculaDAOImpl extends BaseDaoImpl<Matricula> implements MatriculaDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select m from ").append(this.getPersistentClass().getName())
				.append(" m where m.aluno.instituicao.id = :").append(instId);
		
		List<Matricula> list = null;
		
		try {
			list = (List<Matricula>)
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
	public List<Matricula> getByTurma(Turma turma) {
		final String turmaId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select m from ").append(this.getPersistentClass().getName())
				.append(" m where m.turma.id = :").append(turmaId);
		
		List<Matricula> list = null;
		
		try {
			list = (List<Matricula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(turmaId, turma.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> getByTurma(Turma turma, Aluno aluno) {
		final String turmaId = "turmaId";
		final String alunoId = "alunoId";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select m from ").append(this.getPersistentClass().getName())
				.append(" m where m.turma.id = :").append(turmaId)
				.append(" and m.aluno.id = :").append(alunoId);
		
		List<Matricula> list = null;
		
		try {
			list = (List<Matricula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(turmaId, turma.getId())
					.setParameter(alunoId, aluno.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> getByAlunoId(int alunoId) {
		final String alunoIdParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select m from ").append(this.getPersistentClass().getName())
				.append(" m where m.aluno.id = :").append(alunoIdParam);
		
		List<Matricula> list = null;
		
		try {
			list = (List<Matricula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(alunoIdParam, alunoId)
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> getByProfessorId(int professorId) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select m from ").append(this.getPersistentClass().getName())
				.append(" m where m.turma.disciplina.professor.id = :").append(idParam);
		
		List<Matricula> list = null;
		
		try {
			list = (List<Matricula>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, professorId)
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
}
