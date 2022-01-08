package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Lecteur;
import com.repositories.LecteurRepository;

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

    public void deleteLecteur(final Long id) {
    	lecteurRepository.deleteById(id);
    }

    public Lecteur saveLecteur(Lecteur employee) {
    	Lecteur savedLecteur = lecteurRepository.save(employee);
        return savedLecteur;
    }

}
