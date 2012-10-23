package br.com.arkhi.test.arquillian.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Beer {

	@Id
	@SequenceGenerator(name="sq_beer", sequenceName="sq_beer")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_beer")
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@ManyToOne
	private Malt malt;
	
	@ManyToOne
	private Hop hop;
	
	@ManyToOne
	private Yeast yeast;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Malt getMalt() {
		return malt;
	}

	public void setMalt(Malt malt) {
		this.malt = malt;
	}

	public Hop getHop() {
		return hop;
	}

	public void setHop(Hop hop) {
		this.hop = hop;
	}

	public Yeast getYeast() {
		return yeast;
	}

	public void setYeast(Yeast yeast) {
		this.yeast = yeast;
	}
	
	
}
