package br.com.arkhi.test.arquillian.service;

import java.util.List;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Cerveja;

@Local
public interface CervejaService extends GenericService<Cerveja, Long> {
	
	List<Cerveja> findByName(String name);
}
