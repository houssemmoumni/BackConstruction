package tn.esprit.gestion_negociation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_negociation.Entity.DocumentNegociation;

import java.util.List;

@Repository
public interface DocumentNegociationRepository extends JpaRepository<DocumentNegociation, Long> {
    List<DocumentNegociation> findByNegociationId(Long negociationId);
}
