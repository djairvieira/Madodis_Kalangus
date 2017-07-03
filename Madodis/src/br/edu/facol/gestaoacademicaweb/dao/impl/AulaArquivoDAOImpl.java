package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.AulaArquivoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.AulaArquivo;

@Repository
public class AulaArquivoDAOImpl extends BaseDaoImpl<AulaArquivo> implements AulaArquivoDAO {

	@Override
	public List<AulaArquivo> findAll() {
		return super.listarTodos();
	}

	@Override
	public AulaArquivo findById(int id) {
		return super.getById(id);
	}

	@Override
	public void save(AulaArquivo document) {
		super.salvar(document);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AulaArquivo> findAllByAulaId(int aulaId) {
		final String idParam = "idParam";
		
		StringBuilder hql = null;
		List<AulaArquivo> list = null;
		
		try {
				hql = new StringBuilder()
						.append("select a from ").append(this.getPersistentClass().getName())
						.append(" a where a.aula.id = :").append(idParam);
				
				list = (List<AulaArquivo>) this.getCurrentSession().createQuery(hql.toString())
								.setParameter(idParam, aulaId).list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}

	@Override
	public void deleteById(int id) {
		super.remover(id);
	}

}
