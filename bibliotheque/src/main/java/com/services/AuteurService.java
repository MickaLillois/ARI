package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Auteur;
import com.models.Bibliotheque;
import com.repositories.AuteurRepository;

import lombok.Data;

@Service
@Data
public class AuteurService {
	
	@Autowired
    private AuteurRepository auteurRepository;

	public Optional<Auteur> getAuteur(final Long id) {
        return auteurRepository.findById(id);
    }

    public Iterable<Auteur> getAuteurs() {
        return auteurRepository.findAll();
    }
    
    public void createAuteur(String prenom, String nom, Bibliotheque laBiblio) {
    	Auteur unAuteur = new Auteur(prenom, nom, laBiblio);
    	auteurRepository.save(unAuteur);
    }

    public void deleteAuteur(final Long id) {
    	auteurRepository.deleteById(id);
    }

    public Auteur saveAuteur(Auteur auteur) {
    	Auteur savedAuteur = auteurRepository.save(auteur);
        return savedAuteur;
    }
}
