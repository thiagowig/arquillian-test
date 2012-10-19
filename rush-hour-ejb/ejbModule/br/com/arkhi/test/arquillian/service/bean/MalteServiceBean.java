package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Malte;
import br.com.arkhi.test.arquillian.service.MalteService;

@Stateless
public class MalteServiceBean extends JPAServiceBean<Malte, Long> implements MalteService {

	public MalteServiceBean() {
		super(Malte.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
