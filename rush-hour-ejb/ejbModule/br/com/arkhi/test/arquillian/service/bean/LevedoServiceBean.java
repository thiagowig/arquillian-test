package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Levedo;
import br.com.arkhi.test.arquillian.service.LevedoService;

@Stateless
public class LevedoServiceBean extends JPAServiceBean<Levedo, Long> implements LevedoService {

	public LevedoServiceBean() {
		super(Levedo.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
