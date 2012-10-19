package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;
import br.com.arkhi.test.arquillian.entity.Malte;

@Local
public interface MalteService extends GenericService<Malte, Long> {
	
}
