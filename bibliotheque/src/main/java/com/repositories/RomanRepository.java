package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Roman;

@Repository
public interface RomanRepository extends JpaRepository<Roman, Long>{

}
