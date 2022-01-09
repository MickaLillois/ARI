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

import com.exceptions.InvalidIdForBibliothqueException;
import com.exceptions.InvalidStringException;
import com.models.Bibliotheque;
import com.models.Lecteur;
import com.services.BibliothequeService;
import com.services.LecteurService;
import com.tools.Tools;

@Controller
public class LecteurController {

    @Autowired
    private LecteurService lecteurService;
    
    @Autowired
	private BibliothequeService bibliothequeService;
    
    @GetMapping("/getLecteurs")
    public String getLecteurs(Model model) {
    	Iterable<Lecteur> listLecteurs = lecteurService.getLecteurs();
    	model.addAttribute("lecteurs",listLecteurs);
        return "lecteurs";
    }
    
    @PostMapping("/createLecteur")
    public String createLecteur(@RequestParam String prenom,@RequestParam String nom, @RequestParam String idBiblio) throws InvalidIdForBibliothqueException, InvalidStringException  {
    	if(Tools.isLettersString(prenom) && Tools.isLettersString(nom) && Tools.isNumberString(idBiblio)) {
    		Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
    		if(laBiblio.isPresent()) {
    			lecteurService.createLecteur(prenom, nom, laBiblio.get());
    	        return "redirect:/getLecteurs";
    		}
    		else {
    			throw new InvalidIdForBibliothqueException();
    		}
	    }
		else {
			throw new InvalidStringException();
		}
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
    public String updateLecteur(@PathVariable("id") String id, @RequestParam String prenom, @RequestParam String nom, @RequestParam String idBiblio) throws InvalidStringException, InvalidIdForBibliothqueException {
    	if(Tools.isLettersString(prenom) && Tools.isLettersString(nom) && Tools.isNumberString(idBiblio)) {
    		Optional<Lecteur> leLecteur = lecteurService.getLecteur(Long.parseLong(id));
            if(leLecteur.isPresent()) {
            	Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
        		if(laBiblio.isPresent()) {
        			Lecteur notnullLecteur = leLecteur.get();
                	notnullLecteur.setPrenom(prenom);
                	notnullLecteur.setNom(nom);
                	notnullLecteur.setLaBibliotheque(laBiblio.get());
                	lecteurService.saveLecteur(notnullLecteur);
        		}
        		else {
        			throw new InvalidIdForBibliothqueException();
        		}
            }
            return "redirect:/getLecteurs";
    	}
    	else {
    		throw new InvalidStringException();
    	}
    }

}
