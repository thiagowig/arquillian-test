package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Cerveja;

@Local
public interface CervejaService {

	Cerveja create(Cerveja cerveja);
}
