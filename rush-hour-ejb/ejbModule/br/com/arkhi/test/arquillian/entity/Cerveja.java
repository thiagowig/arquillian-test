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
public class Cerveja {

	@Id
	@SequenceGenerator(name="sq_cerveja", sequenceName="sq_cerveja")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_cerveja")
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	@ManyToOne
	private Malte malte;
	
	@ManyToOne
	private Lupulo lupulo;
	
	@ManyToOne
	private Levedo levedo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Malte getMalte() {
		return malte;
	}

	public void setMalte(Malte malte) {
		this.malte = malte;
	}

	public Lupulo getLupulo() {
		return lupulo;
	}

	public void setLupulo(Lupulo lupulo) {
		this.lupulo = lupulo;
	}

	public Levedo getLevedo() {
		return levedo;
	}

	public void setLevedo(Levedo levedo) {
		this.levedo = levedo;
	}
	
	
}
