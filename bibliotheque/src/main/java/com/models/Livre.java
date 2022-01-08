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
public class Livre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	
	@ManyToMany
	private List<Auteur> lesAuteurs = new ArrayList<Auteur>();
	
	@ManyToOne
	private Bibliotheque laBiblio;
	
	protected Livre() {}

	public Livre(String titre) {
		super();
		this.titre = titre;
	}

	public Livre(String titre, List<Auteur> lesAuteurs, Bibliotheque laBiblio) {
		super();
		this.titre = titre;
		this.lesAuteurs = lesAuteurs;
		this.laBiblio = laBiblio;
	}
	
	
}
