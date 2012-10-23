package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Yeast;
import br.com.arkhi.test.arquillian.service.YeastService;

@Stateless
public class YeastServiceBean extends JPAServiceBean<Yeast, Long> implements YeastService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public YeastServiceBean() {
		super(Yeast.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
