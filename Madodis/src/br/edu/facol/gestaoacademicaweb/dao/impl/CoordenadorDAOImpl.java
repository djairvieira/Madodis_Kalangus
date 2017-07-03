package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.CoordenadorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;

@Repository
public class CoordenadorDAOImpl extends BaseDaoImpl<Coordenador> implements CoordenadorDAO {

	public Coordenador autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select c from ").append(this.getPersistentClass().getName())
				.append(" c where c.matricula = :").append(matriculaParam)
				.append(" and c.senha = :").append(senhaParam);
		
		Coordenador coordenador = null;
		
		try {
			coordenador = (Coordenador)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			coordenador = null;
		}
		
		return coordenador;
	}
	
	public Coordenador autenticar(String matricula, String cpf, String rg) {
		final String matriculaParam = "matricula";
		final String cpfParam = "cpf";
		final String rgParam = "rg";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select c from ").append(this.getPersistentClass().getName())
				.append(" c where c.matricula = :").append(matriculaParam)
				.append(" and c.cpf = :").append(cpfParam)
				.append(" and c.rg = :").append(rgParam);
		
		Coordenador coordenador = null;
		
		try {
			coordenador = (Coordenador)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(cpfParam, cpf)
					.setParameter(rgParam, rg)
					.uniqueResult();
		} catch (Exception e) {
			coordenador = null;
		}
		
		return coordenador;
	}
	
	public Coordenador getByEmail(String email) {
		final String emailParam = "email";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.email = :").append(emailParam);
		
		Coordenador coordenador = null;
		
		try {
			coordenador = (Coordenador)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(emailParam, email)
					.uniqueResult();
		} catch (Exception e) {
			coordenador = null;
		}
		
		return coordenador;
	}
	
}
