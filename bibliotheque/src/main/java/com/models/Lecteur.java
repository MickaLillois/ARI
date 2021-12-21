package com.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Lecteur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private LocalDateTime dateNaissance;
	private int idBibliotheque;
	
	protected Lecteur() {}

	public Lecteur(String prenom, String nom, LocalDateTime dateNaissance, int idBibliotheque) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.idBibliotheque = idBibliotheque;
	}

	
}