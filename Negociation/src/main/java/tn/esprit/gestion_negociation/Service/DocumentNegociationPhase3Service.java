package tn.esprit.gestion_negociation.Service;

import tn.esprit.gestion_negociation.Entity.DocumentNegociation;

import java.util.List;

public interface DocumentNegociationPhase3Service {

    DocumentNegociation ajouterDocumentPhase3(Long negociationId, DocumentNegociation document);

    List<DocumentNegociation> listerDocumentsPhase3(Long negociationId);
}