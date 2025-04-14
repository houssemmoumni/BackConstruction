package tn.esprit.gestion_negociation.Service;

import tn.esprit.gestion_negociation.Entity.DocumentNegociation;
import java.util.List;

public interface DocumentNegociationPhase2Service {

    DocumentNegociation ajouterDocumentPhase2(Long negociationId, DocumentNegociation document);

    List<DocumentNegociation> listerDocumentsPhase2(Long negociationId);
}
