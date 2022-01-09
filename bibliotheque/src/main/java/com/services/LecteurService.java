package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.InvalidStringException;
import com.models.Bibliotheque;
import com.models.Lecteur;
import com.repositories.LecteurRepository;
import com.tools.Tools;

import lombok.Data;

@Service
@Data
public class LecteurService {

    @Autowired
    private LecteurRepository lecteurRepository;

    public Optional<Lecteur> getLecteur(final Long id) {
        return lecteurRepository.findById(id);
    }

    public Iterable<Lecteur> getLecteurs() {
        return lecteurRepository.findAll();
    }
    
    public void createLecteur(String prenom, String nom, Bibliotheque laBiblio){
		Lecteur unLecteur = new Lecteur(prenom, nom, laBiblio);
    	lecteurRepository.save(unLecteur);
    }

    public void deleteLecteur(final Long id) {
    	lecteurRepository.deleteById(id);
    }

    public Lecteur saveLecteur(Lecteur lecteur) {
    	Lecteur savedLecteur = lecteurRepository.save(lecteur);
        return savedLecteur;
    }

}
