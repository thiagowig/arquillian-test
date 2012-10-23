package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Hop;
import br.com.arkhi.test.arquillian.service.HopService;

@Stateless
public class HopServiceBean extends JPAServiceBean<Hop, Long> implements HopService {

	@PersistenceContext
	private EntityManager entityManager;

	public HopServiceBean() {
		super(Hop.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
