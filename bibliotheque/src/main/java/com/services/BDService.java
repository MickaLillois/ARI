package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BD;
import com.models.Bibliotheque;
import com.models.Lecteur;
import com.models.Livre;
import com.repositories.BDRepository;

@Service
public class BDService {

	@Autowired
    private BDRepository bdRepository;
	
	public Optional<BD> getBD(final Long id) {
        return bdRepository.findById(id);
    }
	
	public void createBD(String titre, String serie, Bibliotheque laBiblio){
		BD uneBD = new BD(titre, serie, laBiblio);
    	bdRepository.save(uneBD);
    }
	
	public BD saveBD(BD bd) {
    	BD savedBD = bdRepository.save(bd);
        return savedBD;
    }
}
