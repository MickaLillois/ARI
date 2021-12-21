package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Lecteur;

@Repository
public interface LecteurRepository extends JpaRepository<Lecteur, Long> {

}
