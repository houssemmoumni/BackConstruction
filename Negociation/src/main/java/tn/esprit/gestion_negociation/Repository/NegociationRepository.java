
package tn.esprit.gestion_negociation.Repository;

import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.gestion_negociation.Entity.Negociation;
import tn.esprit.gestion_negociation.Entity.NegociationLightDTO;

import java.util.List;
import java.util.Optional;

public interface NegociationRepository extends CrudRepository<Negociation, Long> {


List<Negociation> findAll();
  @Query("SELECT new tn.esprit.gestion_negociation.Entity.NegociationLightDTO(" +
          "n.id, n.budgetEstime, n.dateCreation, n.dateModification, n.demande, " +
          "n.exigences, n.phase, n.status, " +
          "n.administrateur.id, n.architecte.id, n.client.id, n.ingenieurCivil.id) " +
          "FROM Negociation n")
  List<NegociationLightDTO> findAllLight();
  @Query("SELECT new tn.esprit.gestion_negociation.Entity.NegociationLightDTO(" +
          "n.id, n.budgetEstime, n.dateCreation, n.dateModification, n.demande, " +
          "n.exigences, n.phase, n.status, " +
          "n.administrateur.id, n.architecte.id, n.client.id, n.ingenieurCivil.id) " +
          "FROM Negociation n WHERE n.id = :id")
  Optional<NegociationLightDTO> findLightById(@Param("id") Long id);
}