package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Auteur;
import com.models.Bibliotheque;

@Repository
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long>{

}
