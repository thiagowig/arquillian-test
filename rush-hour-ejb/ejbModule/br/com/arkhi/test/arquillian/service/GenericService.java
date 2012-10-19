package br.com.arkhi.test.arquillian.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author thiago
 */
public interface GenericService <Type, PK extends Serializable> {

	Type create(Type object);

    void update(Type object);

    void delete(PK id);

    Type findByPK(PK id);

    List<Type> findAll();

}
