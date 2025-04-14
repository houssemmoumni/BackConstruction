package tn.esprit.gestion_negociation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_negociation.Entity.ContratNegociation;

@Repository
public interface ContratNegociationRepository extends JpaRepository<ContratNegociation, Long> {
    ContratNegociation findByNegociationId(Long negociationId);
}
