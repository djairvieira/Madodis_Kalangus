package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.ProvaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

@Repository
public class ProvaDAOImpl extends BaseDaoImpl<Prova> implements ProvaDAO {

	@Override
	public Prova getByAula(Aula aula) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select f from ").append(this.getPersistentClass().getName())
				.append(" f where f.aula.id = :").append(idParam);
		
		Prova prova = null;
		
		try {
			prova = (Prova)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, aula.getId())
					.uniqueResult();
		} catch (Exception e) {
			prova = null;
		}
		
		return prova;
	}
	
	public Prova salvarComRetorno(Prova prova) {
		return (Prova) this.getCurrentSession().merge(prova);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AlunoProva getProvaByTurmaAndTypeAndStudent(Turma turma, TipoDeAula tipo, Aluno aluno) {
		final String turmaParam = "turma";
		final String tipoParam = "tipo";
		
		StringBuilder hql = new StringBuilder()
				.append("select p from ").append(this.getPersistentClass().getName())
				.append(" p where p.aula.turma.id =  :").append(turmaParam)
				.append(" and p.aula.tipoDeAula = :").append(tipoParam);
		
		List<Prova> provas = null;
		
		try {
			provas = (List<Prova>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(turmaParam, turma.getId())
					.setParameter(tipoParam, tipo)
					.list();
		} catch (Exception e) {
			provas = null;
		}
		
		AlunoProva ap = null;
		
		if (provas != null && provas.size() > 0) {
			for (Prova prova : provas) {
				if (prova.getProvas() != null && prova.getProvas().size() > 0) {
					for (AlunoProva alunoProva : prova.getProvas()) {
						if (alunoProva.getAluno().getId() == aluno.getId()) {
							ap = alunoProva;
							break;
						}
					}
				}
			}
		}
		
		return ap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Prova> getByTurma(Turma turma, int alunoId) {
		final String idParam = "id";
		final String idAlunoParam = "idAluno";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select f from ").append(this.getPersistentClass().getName())
				.append(" f inner join f.provas p where f.aula.turma.id = :").append(idParam)
				.append(" and p.aluno.id = :").append(idAlunoParam);
		
		List<Prova> provas = null;
		
		try {
			provas = (List<Prova>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, turma.getId())
					.setParameter(idAlunoParam, alunoId)
					.list();
		} catch (Exception e) {
			provas = null;
		}
		
		Set<Prova> provaToRetur = null;
		
		if (provas != null) {
			provaToRetur = new HashSet<Prova>(provas);
		}
		
		return provaToRetur;
	}
	
}
