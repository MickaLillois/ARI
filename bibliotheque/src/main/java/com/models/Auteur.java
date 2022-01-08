package com.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Auteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;

	@ManyToMany
	private List<Integer> lesLivres = new ArrayList<Integer>();
	
	@ManyToOne
	private Bibliotheque laBibliotheque;
	
	protected Auteur() {}
}