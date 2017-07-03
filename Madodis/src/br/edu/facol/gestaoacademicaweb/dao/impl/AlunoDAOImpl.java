package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

@Repository
public class AlunoDAOImpl extends BaseDaoImpl<Aluno> implements AlunoDAO {

	public Aluno autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.matricula = :").append(matriculaParam)
				.append(" and a.senha = :").append(senhaParam);
		
		Aluno aluno = null;
		
		try {
			aluno = (Aluno)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			aluno = null;
		}
		
		return aluno;
	}
	
	public Aluno autenticar(String matricula, String cpf, String rg) {
		final String matriculaParam = "matricula";
		final String cpfParam = "cpf";
		final String rgParam = "rg";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.matricula = :").append(matriculaParam)
				.append(" and a.cpf = :").append(cpfParam)
				.append(" and a.rg = :").append(rgParam);
		
		Aluno aluno = null;
		
		try {
			aluno = (Aluno)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(cpfParam, cpf)
					.setParameter(rgParam, rg)
					.uniqueResult();
		} catch (Exception e) {
			aluno = null;
		}
		
		return aluno;
	}
	
	public Aluno getByEmail(String email) {
		final String emailParam = "email";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.email = :").append(emailParam);
		
		Aluno aluno = null;
		
		try {
			aluno = (Aluno)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(emailParam, email)
					.uniqueResult();
		} catch (Exception e) {
			aluno = null;
		}
		
		return aluno;
	}
	
}
