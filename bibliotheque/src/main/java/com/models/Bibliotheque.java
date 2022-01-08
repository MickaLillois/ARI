package com.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Bibliotheque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany
	private List<Lecteur> lesLecteurs;
	
	@OneToMany
	private List<Auteur> lesAuteurs;
	
	@OneToMany
	private List<Livre> lesLivres;

}
