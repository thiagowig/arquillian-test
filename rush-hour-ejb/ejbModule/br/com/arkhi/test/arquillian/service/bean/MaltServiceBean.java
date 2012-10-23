package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Malt;
import br.com.arkhi.test.arquillian.service.MaltService;

@Stateless
public class MaltServiceBean extends JPAServiceBean<Malt, Long> implements MaltService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public MaltServiceBean() {
		super(Malt.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
