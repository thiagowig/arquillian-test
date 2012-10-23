package br.com.arkhi.test.arquillian.service;

import javax.ejb.Local;

import br.com.arkhi.test.arquillian.entity.Yeast;

@Local
public interface YeastService extends GenericService<Yeast, Long> {
	
}
