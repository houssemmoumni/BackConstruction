package tn.esprit.gestion_negociation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_negociation.Entity.DocumentNegociation;
import tn.esprit.gestion_negociation.Entity.Negociation;
import tn.esprit.gestion_negociation.Entity.Role;
import tn.esprit.gestion_negociation.Entity.User;
import tn.esprit.gestion_negociation.Repository.DocumentNegociationRepository;
import tn.esprit.gestion_negociation.Repository.NegociationRepository;

import java.util.List;

@Service
public class DocumentNegociationPhase2ServiceImpl implements DocumentNegociationPhase2Service {

    @Autowired
    private DocumentNegociationRepository documentNegociationRepository;

    @Autowired
    private NegociationRepository negociationRepository;

    private final static User STATIC_ARCHITECT = new User(3L, "Architecte", "Static",
            "architect@example.com", "password", Role.ARCHITECTE);

    @Override
    public DocumentNegociation ajouterDocumentPhase2(Long negociationId, DocumentNegociation document) {
        Negociation negociation = negociationRepository.findById(negociationId)
                .orElseThrow(() -> new RuntimeException("Négociation non trouvée avec l'id " + negociationId));

        if (negociation.getArchitecte() == null) {
            negociation.setArchitecte(STATIC_ARCHITECT);
            negociationRepository.save(negociation);
        }

        document.setNegociation(negociation);
        return documentNegociationRepository.save(document);
    }

    @Override
    public List<DocumentNegociation> listerDocumentsPhase2(Long negociationId) {
        return documentNegociationRepository.findByNegociationId(negociationId);
    }
}
