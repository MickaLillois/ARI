package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Lecteur;
import com.services.LecteurService;

@RestController
public class LecteurController {

    @Autowired
    private LecteurService lecteurService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/lecteurs")
    public Iterable<Lecteur> getLecteurs() {
        return lecteurService.getLecteurs();
    }

}
