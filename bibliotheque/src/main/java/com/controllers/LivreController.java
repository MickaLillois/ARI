package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exceptions.InvalidIdForBibliothqueException;
import com.exceptions.InvalidStringException;
import com.models.BD;
import com.models.Bibliotheque;
import com.models.Lecteur;
import com.models.Livre;
import com.models.Roman;
import com.services.BDService;
import com.services.BibliothequeService;
import com.services.LivreService;
import com.services.RomanService;
import com.tools.Tools;

@Controller
public class LivreController {
	
	@Autowired
    private LivreService livreService;
	
	@Autowired
    private BDService bdService;
	
	@Autowired
    private RomanService romanService;
    
    @Autowired
	private BibliothequeService bibliothequeService;
    
    @GetMapping("/getLivres")
    public String getLivres(Model model) {
    	Iterable<Livre> listLivres = livreService.getLivres();
    	model.addAttribute("livres",listLivres);
        return "livres";
    }
    
    @PostMapping("/createBD")
    public String createBD(@RequestParam String titre,@RequestParam String serie, @RequestParam String idBiblio) throws InvalidIdForBibliothqueException, InvalidStringException  {
    	if(Tools.isLettersString(titre) && Tools.isLettersString(serie) && Tools.isNumberString(idBiblio)) {
    		Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
    		if(laBiblio.isPresent()) {
    			bdService.createBD(titre, serie, laBiblio.get());
    	        return "redirect:/getLivres";
    		}
    		else {
    			throw new InvalidIdForBibliothqueException();
    		}
	    }
		else {
			throw new InvalidStringException();
		}
    }
    
    @PostMapping("/createRoman")
    public String createRoman(@RequestParam String titre, @RequestParam String idBiblio) throws InvalidIdForBibliothqueException, InvalidStringException  {
    	if(Tools.isLettersString(titre) && Tools.isNumberString(idBiblio)) {
    		Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
    		if(laBiblio.isPresent()) {
    			romanService.createRoman(titre, laBiblio.get());
    	        return "redirect:/getLivres";
    		}
    		else {
    			throw new InvalidIdForBibliothqueException();
    		}
	    }
		else {
			throw new InvalidStringException();
		}
    }
    
    @GetMapping("/modifierBD")
    public String modifierBD(@RequestParam(name="id") Long id, Model model) {
        Optional<BD> laBD = bdService.getBD(id);
        if(laBD.isPresent()) {
        	BD notnullBD = laBD.get();
        	model.addAttribute("bd",notnullBD);
        }
        return "modifierBD";
    }
    
    @GetMapping("/modifierRoman")
    public String modifierRoman(@RequestParam(name="id") Long id, Model model) {
        Optional<Roman> leRoman = romanService.getRoman(id);
        if(leRoman.isPresent()) {
        	Roman notnullRoman = leRoman.get();
        	model.addAttribute("roman",notnullRoman);
        }
        return "modifierRoman";
    }
    
    @GetMapping("/deleteLivre")
    public String deleteLivre(@RequestParam(name="id") Long id) {
        livreService.deleteLivre(id);
        return "redirect:/getLivres";
    }
    
    @PostMapping("/updateBD/{id}")
    public String updateBD(@PathVariable("id") String id, @RequestParam String titre, @RequestParam String serie, @RequestParam String idBiblio) throws InvalidStringException, InvalidIdForBibliothqueException {
    	if(Tools.isLettersString(titre) && Tools.isLettersString(serie) && Tools.isNumberString(idBiblio)) {
    		Optional<BD> leBD = bdService.getBD(Long.parseLong(id));
            if(leBD.isPresent()) {
            	Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
        		if(laBiblio.isPresent()) {
        			BD notnullBD = leBD.get();
                	notnullBD.setTitre(titre);
                	notnullBD.setSerie(serie);
                	notnullBD.setLaBiblio(laBiblio.get());
                	bdService.saveBD(notnullBD);
        		}
        		else {
        			throw new InvalidIdForBibliothqueException();
        		}
            }
            return "redirect:/getLivres";
    	}
    	else {
    		throw new InvalidStringException();
    	}
    }
    
    @PostMapping("/updateRoman/{id}")
    public String updateRoman(@PathVariable("id") String id, @RequestParam String titre, @RequestParam String idBiblio) throws InvalidStringException, InvalidIdForBibliothqueException {
    	if(Tools.isLettersString(titre) && Tools.isNumberString(idBiblio)) {
    		Optional<Roman> leRoman = romanService.getRoman(Long.parseLong(id));
            if(leRoman.isPresent()) {
            	Optional<Bibliotheque> laBiblio = bibliothequeService.getBibliotheque(Long.parseLong(idBiblio));
        		if(laBiblio.isPresent()) {
        			Roman notnullRoman = leRoman.get();
                	notnullRoman.setTitre(titre);
                	notnullRoman.setLaBiblio(laBiblio.get());
                	romanService.saveRoman(notnullRoman);
        		}
        		else {
        			throw new InvalidIdForBibliothqueException();
        		}
            }
            return "redirect:/getLivres";
    	}
    	else {
    		throw new InvalidStringException();
    	}
    }

}
