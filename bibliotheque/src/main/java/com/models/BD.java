package com.models;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BD extends Livre {
	
	private String serie;
	
	protected BD() {}
	
	public BD(String titre, String serie) {
		super(titre);
		this.serie = serie;
	}
	
	public BD(String titre, Bibliotheque laBiblio, String serie) {
		super(titre,laBiblio);
		this.serie = serie;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
}
