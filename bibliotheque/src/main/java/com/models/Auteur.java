package com.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Auteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private LocalDateTime dateNaissance;
	private int idBibliotheque;
	
	@OneToMany
	private List<Integer> lesLivres = new ArrayList<Integer>();
	
	protected Auteur() {}
}
