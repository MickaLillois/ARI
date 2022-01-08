package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long>{

}
