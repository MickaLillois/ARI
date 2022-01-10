package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Livre;
import com.repositories.LivreRepository;

@Service
public class LivreService {
	
	@Autowired
    private LivreRepository livreRepository;

    public Optional<Livre> getLivre(final Long id) {
        return livreRepository.findById(id);
    }

    public Iterable<Livre> getLivres() {
        return livreRepository.findAll();
    }
    
    public void deleteLivre(final Long id) {
    	livreRepository.deleteById(id);
    }

}
