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
	private Long id;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Bibliotheque getLaBibliotheque() {
		return laBibliotheque;
	}

	public void setLaBibliotheque(Bibliotheque laBibliotheque) {
		this.laBibliotheque = laBibliotheque;
	}

	@Override
	public String toString() {
		return "Lecteur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", laBibliotheque=" + laBibliotheque + "]";
	}
	
	
	
}