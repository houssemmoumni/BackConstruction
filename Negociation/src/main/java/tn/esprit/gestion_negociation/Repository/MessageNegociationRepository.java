package tn.esprit.gestion_negociation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_negociation.Entity.MessageNegociation;

import java.util.List;

@Repository
public interface MessageNegociationRepository extends JpaRepository<MessageNegociation, Long> {

    List<MessageNegociation> findByNegociationId(Long negociationId);
}