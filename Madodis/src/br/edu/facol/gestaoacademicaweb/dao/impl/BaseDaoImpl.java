package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.edu.facol.gestaoacademicaweb.dao.BaseDao;
import br.edu.facol.gestaoacademicaweb.pojo.BaseObject;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public abstract class BaseDaoImpl<T extends BaseObject> extends HibernateDaoSupport implements BaseDao<T> {
	
	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	@Override
	public void salvar(T entity) {
		this.getCurrentSession().save(entity);
	}

	@Override
	public void atualizar(T entity) {
		this.getCurrentSession().update(entity);;
	}

	@Override
	public void remover(T entity) {
		this.getCurrentSession().delete(entity);
	}

	@Override
	public boolean remover(int id) {
		final String idParam = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("delete from ").append(this.getPersistentClass().getName())
				.append(" where id = :").append(idParam);
		
		int deleteCount = 
			this.getCurrentSession().createQuery(hql.toString())
				.setParameter(idParam, id)
				.executeUpdate();
		
		return deleteCount > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(int id) {
		return (T) this.getCurrentSession().get(getPersistentClass(), id);
	}
	
	public T get(int id, boolean lazy) {
		T entity = (T) getById(id);
		if (entity != null && !lazy) {
			Hibernate.initialize(entity);
			Field[] fields = getPersistentClass().getDeclaredFields(); 
			if (fields != null && fields.length > 0) {
				for (int i = 0; i < fields.length; i++ ) {
					this.unLazy(entity, fields[i].getName()); 
			    } 
			}   
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {
		return this.getCurrentSession().createCriteria(getPersistentClass()).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(Instituicao instituicao) {
		final String instId = "id";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select p from ").append(this.getPersistentClass().getName())
				.append(" p where p.instituicao.id = :").append(instId);
		
		List<T> list = null;
		
		try {
			list = (List<T>)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(instId, instituicao.getId())
					.list();
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	protected Criteria createEntityCriteria(){
        return getCurrentSession().createCriteria(getPersistentClass());
    }
	
	protected Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	private void unLazy(T entity, String property) {
		if (entity != null) {
			try {
				BeanUtils.getProperty(entity, property);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByFieldName(int id, String fieldName, String fieldValue) {
		final String idParam = "idParam";
		final String fieldValueParam = "fieldValueParam";
		
		StringBuilder hql = null;
		List<T> list = null;
		
		try {
			if (id > 0) {
				hql = new StringBuilder()
						.append("select a from ").append(this.getPersistentClass().getName())
						.append(" a where a.").append(fieldName).append(" = :").append(fieldValueParam)
						.append(" and a.id != :").append(idParam);
				
				list = (List<T>) this.getCurrentSession().createQuery(hql.toString())
								.setParameter(fieldValueParam, fieldValue)
								.setParameter(idParam, id).list();
			
			} else {
				hql = new StringBuilder()
						.append("select a from ").append(this.getPersistentClass().getName())
						.append(" a where a.").append(fieldName).append(" = :").append(fieldValueParam);
				
				list = (List<T>) this.getCurrentSession().createQuery(hql.toString())
						.setParameter(fieldValueParam, fieldValue).list();
			}
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}

}
