package com.example.negociation.repositories;

import com.example.negociation.entities.Negociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NegociationRepository extends JpaRepository<Negociation, Long> {
    List<Negociation> findByClientId(int clientId);

    List<Negociation> findByClientId(Long clientId);
}