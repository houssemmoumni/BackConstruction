package com.example.negociation.repositories;

import com.example.negociation.entities.ContratNegociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratNegociationRepository extends JpaRepository<ContratNegociation, Long> {
    Optional<ContratNegociation> findByNegociationId(Long negociationId);
}