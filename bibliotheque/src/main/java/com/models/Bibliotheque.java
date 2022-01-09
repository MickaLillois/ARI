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
	}

	@Override
	public String toString() {
		return nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Lecteur> getLesLecteurs() {
		return lesLecteurs;
	}

	public void setLesLecteurs(List<Lecteur> lesLecteurs) {
		this.lesLecteurs = lesLecteurs;
	}

	public List<Auteur> getLesAuteurs() {
		return lesAuteurs;
	}

	public void setLesAuteurs(List<Auteur> lesAuteurs) {
		this.lesAuteurs = lesAuteurs;
	}

	public List<Livre> getLesLivres() {
		return lesLivres;
	}

	public void setLesLivres(List<Livre> lesLivres) {
		this.lesLivres = lesLivres;
	};
	
	
	
}
