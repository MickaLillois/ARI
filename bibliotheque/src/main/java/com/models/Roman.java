package com.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Roman extends Livre {

	protected Roman() {}
	
	public Roman(String titre) {
		super(titre);
	}

	public Roman(String titre, Bibliotheque laBiblio) {
		super(titre,laBiblio);
	}

	@Override
	public String getLibelle() {
		return titre;
	}
	
}
