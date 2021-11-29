package models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.idBibliotheque = idBibliotheque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDateTime getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDateTime dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public int getIdBibliotheque() {
		return idBibliotheque;
	}

	
	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}
	
}