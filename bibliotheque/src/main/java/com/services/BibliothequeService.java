package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Bibliotheque;
import com.repositories.BibliothequeRepository;

import lombok.Data;

@Service
@Data
public class BibliothequeService {

    @Autowired
    private BibliothequeRepository bibliothequeRepository;

    public Optional<Bibliotheque> getBibliotheque(final Long id) {
        return bibliothequeRepository.findById(id);
    }
}