package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Lupulo;
import br.com.arkhi.test.arquillian.service.LupuloService;

@Stateless
public class LupuloServiceBean extends JPAServiceBean<Lupulo, Long> implements LupuloService {

	public LupuloServiceBean() {
		super(Lupulo.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
