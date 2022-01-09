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
	private Long id;
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
	
	public Auteur(String prenom, String nom, Bibliotheque laBibliotheque) {
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

	public List<Livre> getLesLivres() {
		return lesLivres;
	}

	public void setLesLivres(List<Livre> lesLivres) {
		this.lesLivres = lesLivres;
	}

	public Bibliotheque getLaBibliotheque() {
		return laBibliotheque;
	}

	public void setLaBibliotheque(Bibliotheque laBibliotheque) {
		this.laBibliotheque = laBibliotheque;
	}
	
	
}