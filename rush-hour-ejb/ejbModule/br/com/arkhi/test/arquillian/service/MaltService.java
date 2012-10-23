package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;
import br.com.arkhi.test.arquillian.entity.Malt;

@Local
public interface MaltService extends GenericService<Malt, Long> {
	
}
