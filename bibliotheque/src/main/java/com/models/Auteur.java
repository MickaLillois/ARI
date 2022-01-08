package com.models;

import java.time.LocalDateTime;
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
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Auteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;

	@ManyToMany
	private List<Livre> lesLivres = new ArrayList<Livre>();
	
	@ManyToOne
	private Bibliotheque laBibliotheque;
	
	protected Auteur() {}

	public Auteur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	
	
}