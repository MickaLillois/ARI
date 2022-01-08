package com.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Lecteur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	private String nom;

	@ManyToOne
	private Bibliotheque laBibliotheque;
	
	protected Lecteur() {}
	
	public Lecteur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Lecteur(String prenom, String nom, Bibliotheque laBibliotheque) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.laBibliotheque = laBibliotheque;
	}
	
	
	
}