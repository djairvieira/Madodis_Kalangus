package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.SecretariaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;

@Repository
public class SecretariaDAOImpl extends BaseDaoImpl<Secretaria> implements SecretariaDAO {

	public Secretaria autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select s from ").append(this.getPersistentClass().getName())
				.append(" s where s.matricula = :").append(matriculaParam)
				.append(" and s.senha = :").append(senhaParam);
		
		Secretaria secretaria = null;
		
		try {
			secretaria = (Secretaria)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			secretaria = null;
		}
		
		return secretaria;
	}
	
	public Secretaria autenticar(String matricula, String cpf, String rg) {
		final String matriculaParam = "matricula";
		final String cpfParam = "cpf";
		final String rgParam = "rg";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select s from ").append(this.getPersistentClass().getName())
				.append(" s where s.matricula = :").append(matriculaParam)
				.append(" and s.cpf = :").append(cpfParam)
				.append(" and s.rg = :").append(rgParam);
		
		Secretaria secretaria = null;
		
		try {
			secretaria = (Secretaria)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(cpfParam, cpf)
					.setParameter(rgParam, rg)
					.uniqueResult();
		} catch (Exception e) {
			secretaria = null;
		}
		
		return secretaria;
	}
	
	public Secretaria getByEmail(String email) {
		final String emailParam = "email";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.email = :").append(emailParam);
		
		Secretaria secretaria = null;
		
		try {
			secretaria = (Secretaria)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(emailParam, email)
					.uniqueResult();
		} catch (Exception e) {
			secretaria = null;
		}
		
		return secretaria;
	}
	
}
