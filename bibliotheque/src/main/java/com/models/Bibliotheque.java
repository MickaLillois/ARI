package com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Bibliotheque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany
	private List<Lecteur> lesLecteurs;
	
	@OneToMany
	private List<Auteur> lesAuteurs;
	
	@OneToMany
	private List<Livre> lesLivres;

	protected Bibliotheque() {}

	public Bibliotheque(String nom) {
		super();
		this.nom = nom;
	};
	
	
}
