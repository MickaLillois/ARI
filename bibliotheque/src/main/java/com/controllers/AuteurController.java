package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Auteur;
import com.services.AuteurService;

@Controller
public class AuteurController {

	@Autowired
    private AuteurService auteurService;
    
    @GetMapping("/getAuteurs")
    public String getAuteurs(Model model) {
    	Iterable<Auteur> listAuteurs = auteurService.getAuteurs();
    	model.addAttribute("auteurs",listAuteurs);
        return "auteurs";
    }
    
    @PostMapping("/createAuteur")
    public String createAuteur(@RequestParam String prenom,@RequestParam String nom) {
        auteurService.createAuteur(prenom, nom);
        return "home";
    }
    
    
    @GetMapping("/modifierAuteur")
    public String modifierAuteur(@RequestParam(name="id") Long id, Model model) {
        Optional<Auteur> leAuteur = auteurService.getAuteur(id);
        if(leAuteur.isPresent()) {
        	Auteur notnullAuteur = leAuteur.get();
        	model.addAttribute("auteur",notnullAuteur);
        }
        return "modifierAuteur";
    }
    
    @GetMapping("/deleteAuteur")
    public String deleteAuteur(@RequestParam(name="id") Long id) {
        auteurService.deleteAuteur(id);
        return "redirect:/getAuteurs";
    }
    
    @PostMapping("/updateAuteur/{id}")
    public String updateAuteur(@PathVariable("id") String id, @RequestParam String prenom, @RequestParam String nom) {
    	Optional<Auteur> leAuteur = auteurService.getAuteur(Long.parseLong(id));
        if(leAuteur.isPresent()) {
        	Auteur notnullAuteur = leAuteur.get();
        	notnullAuteur.setPrenom(prenom);
        	notnullAuteur.setNom(nom);
        	auteurService.saveAuteur(notnullAuteur);
        }
    	return "redirect:/getAuteurs";
    }
	
}
