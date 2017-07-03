package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.FrequenciaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

@Repository
public class FrequenciaDAOImpl extends BaseDaoImpl<Frequencia> implements FrequenciaDAO {

	@Override
	public Frequencia getByAula(Aula aula) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select f from ").append(this.getPersistentClass().getName())
				.append(" f where f.aula.id = :").append(idParam);
		
		Frequencia frequencia = null;
		
		try {
			frequencia = (Frequencia)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, aula.getId())
					.uniqueResult();
		} catch (Exception e) {
			frequencia = null;
		}
		
		return frequencia;
	}
	
	public Frequencia salvarComRetorno(Frequencia frequencia) {
		return (Frequencia) this.getCurrentSession().merge(frequencia);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Frequencia> getByTurma(Turma turma, int alunoId) {
		final String idParam = "id";
		final String idAlunoParam = "idAluno";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select f from ").append(this.getPersistentClass().getName())
				.append(" f inner join f.frequencias p where f.aula.turma.id = :").append(idParam)
				.append(" and p.aluno.id = :").append(idAlunoParam);
		
		List<Frequencia> frequencias = null;
		
		try {
			frequencias = (List<Frequencia>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, turma.getId())
					.setParameter(idAlunoParam, alunoId)
					.list();
		} catch (Exception e) {
			frequencias = null;
		}
		
		return frequencias;
	}
	
}
