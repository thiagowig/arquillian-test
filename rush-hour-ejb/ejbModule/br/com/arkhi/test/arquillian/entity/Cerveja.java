package br.com.arkhi.test.arquillian.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Cerveja {

	@Id
	@SequenceGenerator(name="sq_cerveja", sequenceName="sq_cerveja")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_cerveja")
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@ManyToMany
	private List<Malte> maltes;
	
	@ManyToMany
	private List<Lupulo> lupulos;
	
	@ManyToMany
	private List<Levedo> levedos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Malte> getMaltes() {
		return maltes;
	}

	public void setMaltes(List<Malte> maltes) {
		this.maltes = maltes;
	}

	public List<Lupulo> getLupulos() {
		return lupulos;
	}

	public void setLupulos(List<Lupulo> lupulos) {
		this.lupulos = lupulos;
	}

	public List<Levedo> getLevedos() {
		return levedos;
	}

	public void setLevedos(List<Levedo> levedos) {
		this.levedos = levedos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
