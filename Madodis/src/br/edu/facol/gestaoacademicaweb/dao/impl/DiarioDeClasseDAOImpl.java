package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.DiarioDeClasseDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.DiarioDeClasse;

@Repository
public class DiarioDeClasseDAOImpl extends BaseDaoImpl<DiarioDeClasse> implements DiarioDeClasseDAO {

	@Override
	public DiarioDeClasse getByAula(Aula aula) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select f from ").append(this.getPersistentClass().getName())
				.append(" f where f.aula.id = :").append(idParam);
		
		DiarioDeClasse diarioDeClasse = null;
		
		try {
			diarioDeClasse = (DiarioDeClasse)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(idParam, aula.getId())
					.uniqueResult();
		} catch (Exception e) {
			diarioDeClasse = null;
		}
		
		return diarioDeClasse;
	}
	
	public DiarioDeClasse salvarComRetorno(DiarioDeClasse diarioDeClasse) {
		return (DiarioDeClasse) this.getCurrentSession().merge(diarioDeClasse);
	}
	
}
