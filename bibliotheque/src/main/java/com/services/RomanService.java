package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BD;
import com.models.Bibliotheque;
import com.models.Livre;
import com.models.Roman;
import com.repositories.RomanRepository;

@Service
public class RomanService {
	
	@Autowired
    private RomanRepository romanRepository;
	
	public Optional<Roman> getRoman(final Long id) {
        return romanRepository.findById(id);
    }
	
	public void createRoman(String titre, Bibliotheque laBiblio){
		Roman unRoman = new Roman(titre, laBiblio);
    	romanRepository.save(unRoman);
    }
	
	public Roman saveRoman(Roman roman) {
    	Roman savedRoman = romanRepository.save(roman);
        return savedRoman;
    }

}
