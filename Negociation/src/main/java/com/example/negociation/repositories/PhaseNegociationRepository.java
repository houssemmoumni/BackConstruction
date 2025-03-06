package com.example.negociation.repositories;

import com.example.negociation.entities.PhaseNegociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhaseNegociationRepository extends JpaRepository<PhaseNegociation, Long> {
    List<PhaseNegociation> findByNegociationId(Long negociationId);
    List<PhaseNegociation> findByNegociationIdAndStatut(Long negociationId, String statut);
}