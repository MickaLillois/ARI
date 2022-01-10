package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.models.*;
import com.repositories.AuteurRepository;
import com.repositories.BibliothequeRepository;
import com.repositories.LecteurRepository;
import com.repositories.LivreRepository;
import com.services.BibliothequeService;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class BibliothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}
	
	@Autowired
	private BibliothequeService bibli;

	//Ce code me permet d'instancier quelques données d'essai pour la suite
	@Bean
    public CommandLineRunner init(AuteurRepository auteurRepository, LecteurRepository lecteurRepository, LivreRepository livreRepository, BibliothequeRepository bibliothequeRepository) {
        return args -> {

        	Bibliotheque biblio = new Bibliotheque("Bibliotheque Universitaire de Lille");
        	biblio = bibliothequeRepository.save(biblio);
        	biblio = new Bibliotheque("Bibliotheque Universitaire de Montpellier");
        	biblio = bibliothequeRepository.save(biblio);
        	
        	Bibliotheque laBiblio = bibli.getBibliotheque(Long.parseLong("1")).get();
            Auteur auteur = new Auteur("Rene", "Grousset",laBiblio);
            auteur = auteurRepository.save(auteur);
            auteur = new Auteur("Victor", "Hugo",laBiblio);
            auteur = auteurRepository.save(auteur);
            laBiblio = bibli.getBibliotheque(Long.parseLong("2")).get();
            auteur = new Auteur("Jean", "Racine",laBiblio);
            auteur = auteurRepository.save(auteur);
            auteur = new Auteur("Guillaume", "Apollinaire",laBiblio);
            auteur = auteurRepository.save(auteur);
            
            laBiblio = bibli.getBibliotheque(Long.parseLong("1")).get();
            Lecteur lecteur = new Lecteur("Mickael", "Carceles",laBiblio);
            lecteur = lecteurRepository.save(lecteur);
            laBiblio = bibli.getBibliotheque(Long.parseLong("2")).get();
            lecteur = new Lecteur("Lucas", "Perpere",laBiblio);
            lecteur = lecteurRepository.save(lecteur);
            lecteur = new Lecteur("Gauthier", "Henault",laBiblio);
            lecteur = lecteurRepository.save(lecteur);
            
            Livre unLivre = new Roman("Les Miserables",laBiblio);
            unLivre = livreRepository.save(unLivre);
            unLivre = new BD("Objectif Lune","Les aventures de Tintin",laBiblio);
            unLivre = livreRepository.save(unLivre);
            
            
        };
    }
}
