package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.BD;

@Repository
public interface BDRepository extends JpaRepository<BD, Long> {

}
