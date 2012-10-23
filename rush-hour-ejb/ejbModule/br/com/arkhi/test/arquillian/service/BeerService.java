package br.com.arkhi.test.arquillian.service;

import java.util.List;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Beer;
import br.com.arkhi.test.arquillian.entity.Yeast;
import br.com.arkhi.test.arquillian.entity.Hop;
import br.com.arkhi.test.arquillian.entity.Malt;

@Local
public interface BeerService extends GenericService<Beer, Long> {
	
	List<Beer> findByName(String name);
	
	List<Beer> findByMaltHopAndYeast(Malt malt, Hop hop, Yeast yeast);
	
}
