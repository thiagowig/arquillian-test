package br.com.arkhi.test.arquillian.service;

import java.io.Serializable;
import java.util.List;

import br.com.arkhi.test.arquillian.exception.DataValidationException;

/**
 * @author thiago
 */
public interface GenericService <Type, PK extends Serializable> {

	Type create(Type object) throws DataValidationException;

    void update(Type object) throws DataValidationException;

    void delete(PK id);

    Type findByPK(PK id);

    List<Type> findAll();

}
