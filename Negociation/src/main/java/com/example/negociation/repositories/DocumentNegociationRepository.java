package com.example.negociation.repositories;

import com.example.negociation.entities.DocumentNegociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentNegociationRepository extends JpaRepository<DocumentNegociation, Long> {
    List<DocumentNegociation> findByTacheId(Long tacheId);
}