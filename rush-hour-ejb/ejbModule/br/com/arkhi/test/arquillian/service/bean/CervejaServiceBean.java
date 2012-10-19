package br.com.arkhi.test.arquillian.service.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ValidationException;

import br.com.arkhi.test.arquillian.entity.Cerveja;
import br.com.arkhi.test.arquillian.service.CervejaService;

/**
 * 
 * @author thiago
 *
 */
@Stateless
public class CervejaServiceBean extends JPAServiceBean<Cerveja, Long> implements CervejaService {

	public CervejaServiceBean() {
		super(Cerveja.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 */
	@Override
	protected void validadeInsert(Cerveja cerveja) {
		if (cerveja.getNome() == null || cerveja.getNome().equals("")) {
			throw new ValidationException("O nome da cerveja é obrigatório.");
		}
		
		List<Cerveja> cervejaExistente = this.findByName(cerveja.getNome());
		
		if (!cervejaExistente.isEmpty()) {
			throw new ValidationException("Já existe uma cerveja cadastrada com o nome " + cerveja.getNome());
		}
	}

	/**
	 * 
	 */
	@Override
	public List<Cerveja> findByName(String name) {
		Query query = this.entityManager.createQuery("FROM Cerveja WHERE nome = :nome");  
		query.setParameter("nome", name);
        
		return query.getResultList();
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
