package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.models.Lecteur;
import com.services.LecteurService;

@Controller
public class LecteurController {

    @Autowired
    private LecteurService lecteurService;
    
    @GetMapping("/getLecteurs")
    public String getLecteurs(Model model) {
    	Iterable<Lecteur> listLecteurs = lecteurService.getLecteurs();
    	model.addAttribute("lecteurs",listLecteurs);
        return "lecteurs";
    }
    
    @PostMapping("/createLecteur")
    public String createLecteur(@RequestParam String prenom,@RequestParam String nom) {
        lecteurService.createLecteur(prenom, nom);
        return "home";
    }
    
    
    @GetMapping("/modifierLecteur")
    public String modifierLecteur(@RequestParam(name="id") Long id, Model model) {
        Optional<Lecteur> leLecteur = lecteurService.getLecteur(id);
        if(leLecteur.isPresent()) {
        	Lecteur notnullLecteur = leLecteur.get();
        	model.addAttribute("lecteur",notnullLecteur);
        }
        return "modifierLecteur";
    }
    
    @GetMapping("/deleteLecteur")
    public String deleteLecteur(@RequestParam(name="id") Long id) {
        lecteurService.deleteLecteur(id);
        return "redirect:/getLecteurs";
    }
    
    @PostMapping("/updateLecteur/{id}")
    public String updateLecteur(@PathVariable("id") String id, @RequestParam String prenom, @RequestParam String nom) {
    	Optional<Lecteur> leLecteur = lecteurService.getLecteur(Long.parseLong(id));
        if(leLecteur.isPresent()) {
        	Lecteur notnullLecteur = leLecteur.get();
        	notnullLecteur.setPrenom(prenom);
        	notnullLecteur.setNom(nom);
        	lecteurService.saveLecteur(notnullLecteur);
        }
    	return "redirect:/getLecteurs";
    }

}
