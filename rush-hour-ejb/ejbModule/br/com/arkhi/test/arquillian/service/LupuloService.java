package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Lupulo;

@Local
public interface LupuloService extends GenericService<Lupulo, Long> {
	
}
