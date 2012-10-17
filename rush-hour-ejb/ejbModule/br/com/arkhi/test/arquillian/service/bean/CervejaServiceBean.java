package br.com.arkhi.test.arquillian.service.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.arkhi.test.arquillian.entity.Cerveja;
import br.com.arkhi.test.arquillian.service.CervejaService;

@Stateless
public class CervejaServiceBean implements CervejaService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Cerveja create(Cerveja cerveja) {
		this.entityManager.persist(cerveja);
		
		return cerveja;
	}

}
