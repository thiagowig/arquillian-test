package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Levedo;

@Local
public interface LevedoService extends GenericService<Levedo, Long> {
	
}
