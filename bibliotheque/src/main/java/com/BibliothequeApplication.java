package com;

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

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class BibliothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}

	@Bean
    public CommandLineRunner init(AuteurRepository auteurRepository, LecteurRepository lecteurRepository, LivreRepository livreRepository, BibliothequeRepository bibliothequeRepository) {
        return args -> {

        	Bibliotheque biblio = new Bibliotheque("Biblio 1");
        	biblio = bibliothequeRepository.save(biblio);
        	
            Auteur auteur = new Auteur("Rene", "Grousset");
            auteur = auteurRepository.save(auteur);
            auteur = new Auteur("Victor", "Hugo");
            auteur = auteurRepository.save(auteur);
            auteur = new Auteur("Jean", "Racine");
            auteur = auteurRepository.save(auteur);
            auteur = new Auteur("Guillaume", "Apollinaire");
            auteur = auteurRepository.save(auteur);
            
            Lecteur lecteur = new Lecteur("Mickael", "Carceles");
            lecteur = lecteurRepository.save(lecteur);
            lecteur = new Lecteur("Lucas", "Perpere");
            lecteur = lecteurRepository.save(lecteur);
            lecteur = new Lecteur("Gauthier", "Henault");
            lecteur = lecteurRepository.save(lecteur);
            
        };
    }
}
