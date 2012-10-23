package br.com.arkhi.test.arquillian.service.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.arkhi.test.arquillian.entity.Beer;
import br.com.arkhi.test.arquillian.entity.Hop;
import br.com.arkhi.test.arquillian.entity.Malt;
import br.com.arkhi.test.arquillian.entity.Yeast;
import br.com.arkhi.test.arquillian.exception.DataValidationException;
import br.com.arkhi.test.arquillian.service.BeerService;

/**
 * 
 * @author thiago
 *
 */
@Stateless
public class BeerServiceBean extends JPAServiceBean<Beer, Long> implements BeerService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public BeerServiceBean() {
		super(Beer.class);
	}
	
	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Beer> findByName(String name) {
		Query query = this.entityManager.createQuery("FROM " + Beer.class.getName() + " WHERE name = :name");  
		query.setParameter("name", name);
        
		return query.getResultList();
	}
	
	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Beer> findByMaltHopAndYeast(Malt malt, Hop hop, Yeast yeast) {
		StringBuilder queryBuilder = new StringBuilder("FROM " + Beer.class.getName() + " obj ");
		queryBuilder.append("WHERE obj.malt = :malt ");
		queryBuilder.append("AND obj.hop = :hop ");
		queryBuilder.append("AND obj.yeast = :yeast ");
		
		Query query = this.entityManager.createQuery(queryBuilder.toString());  
		query.setParameter("malt", malt);
		query.setParameter("hop", hop);
		query.setParameter("yeast", yeast);
        
		return query.getResultList();
	}

	/**
	 * @throws DataValidationException 
	 * 
	 */
	@Override
	protected void validateInsert(Beer beer) throws DataValidationException {
		this.validateBeerName(beer);
		
		this.validateBeerRelationship(beer);
		
		this.validateExistingBeer(beer);
	}

	/**
	 * 
	 * @param beer
	 * @throws DataValidationException 
	 */
	private void validateBeerName(Beer beer) throws DataValidationException {
		if (beer.getName() == null || beer.getName().equals("")) {
			throw new DataValidationException("O nome da cerveja é obrigatório.");
		}
	}
	
	/**
	 * 
	 * @param beer
	 * @throws DataValidationException 
	 */
	private void validateExistingBeer(Beer beer) throws DataValidationException {
		List<Beer> existingBeer = this.findByName(beer.getName());
		
		if (!existingBeer.isEmpty()) {
			throw new DataValidationException("Já existe uma cerveja cadastrada com o nome " + beer.getName());
		}
		
		existingBeer = this.findByMaltHopAndYeast(beer.getMalt(), beer.getHop(), beer.getYeast());
		
		if (!existingBeer.isEmpty()) {
			throw new DataValidationException("Já existe uma cerveja cadastrada com este malte, lúpulo e levedo");
		}
	}

	/**
	 * 
	 * @param beer
	 * @throws DataValidationException 
	 */
	private void validateBeerRelationship(Beer beer) throws DataValidationException {
		if (beer.getMalt() == null || beer.getMalt().getId() == null) {
			throw new DataValidationException("O malte é obrigatório");
		}
		
		if (beer.getHop() == null || beer.getHop().getId() == null) {
			throw new DataValidationException("O lúpulo é obrigatório");
		}
		
		if (beer.getYeast() == null || beer.getYeast().getId() == null) {
			throw new DataValidationException("O levedo é obrigatório");
		}
	}
	
	/**
	 * 
	 */
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
