package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.repositories.AuteurRepository;

public class AuteurService {
	
	@Autowired
    private AuteurRepository auteurRepository;

}
