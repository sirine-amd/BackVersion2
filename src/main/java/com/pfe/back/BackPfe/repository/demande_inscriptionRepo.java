package com.pfe.back.BackPfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.back.BackPfe.entities.FileDB;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.entities.demande_inscription;


@Repository
public interface demande_inscriptionRepo extends JpaRepository<demande_inscription, Long> {
	List<demande_inscription> findByType(String type);

}
