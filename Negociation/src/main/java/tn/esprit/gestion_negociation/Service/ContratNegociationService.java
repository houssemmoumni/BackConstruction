package tn.esprit.gestion_negociation.Service;


import tn.esprit.gestion_negociation.Entity.ContratNegociation;

public interface ContratNegociationService {

    ContratNegociation genererContrat(Long negociationId, String contenu);

    ContratNegociation getContratByNegociationId(Long negociationId);
}