package br.com.arkhi.test.arquillian.service.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.arkhi.test.arquillian.exception.DataValidationException;
import br.com.arkhi.test.arquillian.service.GenericService;

/*
 * 
 */
public abstract class JPAServiceBean<Type, PK extends Serializable> implements GenericService<Type, PK> {

	/** */
	protected abstract EntityManager getEntityManager();
	/** */
	private Class<Type> entityClass;
	
	/**
	 * 
	 * @param entityClass
	 */
	public JPAServiceBean(Class<Type> entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * @throws DataValidationException 
	 * 
	 */
	@Override
	public Type create(Type object) throws DataValidationException {
		this.validateInsert(object);
		this.getEntityManager().persist(object);
		
		return object;
	}

	/**
	 * @throws DataValidationException 
	 * 
	 */
	@Override
	public void update(Type object) throws DataValidationException {
		this.validateInsert(object);
		this.getEntityManager().merge(object);
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @throws DataValidationException 
	 */
	protected void validateInsert(Type object) throws DataValidationException {
	}

	/**
	 * 
	 */
	@Override
	public void delete(PK id) {
		Type obj = this.findByPK(id);
		
		this.getEntityManager().remove(obj);
	}

	/**
	 * 
	 */
	@Override
	public Type findByPK(PK id) {
		return this.getEntityManager().find(this.entityClass, id);
	}

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Type> findAll() {
		StringBuilder jpql = new StringBuilder("FROM " + entityClass.getName());
		Query query = this.getEntityManager().createQuery(jpql.toString());
		
		return query.getResultList();
	}

	
	
}
