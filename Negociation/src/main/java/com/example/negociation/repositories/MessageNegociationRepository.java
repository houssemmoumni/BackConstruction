package com.example.negociation.repositories;

import com.example.negociation.entities.MessageNegociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageNegociationRepository extends JpaRepository<MessageNegociation, Long> {
    List<MessageNegociation> findByNegociationIdOrderByDateEnvoiAsc(Long negociationId);
}