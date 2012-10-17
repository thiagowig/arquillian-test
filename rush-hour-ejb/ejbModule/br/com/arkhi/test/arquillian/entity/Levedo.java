package br.com.arkhi.test.arquillian.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Levedo {

	@Id
	private String nome;
	
	@ManyToMany
	private List<Cerveja> cervejas;
}
