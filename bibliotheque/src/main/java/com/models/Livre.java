package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public abstract class Livre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	@ManyToMany
	private List<Auteur> lesAuteurs = new ArrayList<Auteur>();
	
	@ManyToOne
	private Bibliotheque laBiblio;
	
	protected Livre() {}

	protected Livre(String titre) {
		super();
		this.titre = titre;
	}

	protected Livre(String titre, Bibliotheque laBiblio) {
		super();
		this.titre = titre;
		//this.lesAuteurs = lesAuteurs;
		this.laBiblio = laBiblio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Auteur> getLesAuteurs() {
		return lesAuteurs;
	}

	public void setLesAuteurs(List<Auteur> lesAuteurs) {
		this.lesAuteurs = lesAuteurs;
	}

	public Bibliotheque getLaBiblio() {
		return laBiblio;
	}

	public void setLaBiblio(Bibliotheque laBiblio) {
		this.laBiblio = laBiblio;
	}
	
	
}
