package com.example.negociation.repositories;

import com.example.negociation.entities.TacheNegociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheNegociationRepository extends JpaRepository<TacheNegociation, Long> {
    List<TacheNegociation> findByPhaseId(int phaseId);
}