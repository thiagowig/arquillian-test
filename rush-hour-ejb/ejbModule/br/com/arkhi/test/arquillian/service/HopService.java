package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Hop;

@Local
public interface HopService extends GenericService<Hop, Long> {
	
}
