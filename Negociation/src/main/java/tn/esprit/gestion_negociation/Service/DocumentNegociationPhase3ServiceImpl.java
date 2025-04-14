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
public class DocumentNegociationPhase3ServiceImpl implements DocumentNegociationPhase3Service {

    @Autowired
    private DocumentNegociationRepository documentNegociationRepository;

    @Autowired
    private NegociationRepository negociationRepository;

    private final static User STATIC_ENGINEER = new User(4L, "Ingénieur", "Civil",
            "engineer@example.com", "password", Role.INGENIEUR_CIVIL);

    @Override
    public DocumentNegociation ajouterDocumentPhase3(Long negociationId, DocumentNegociation document) {
        Negociation negociation = negociationRepository.findById(negociationId)
                .orElseThrow(() -> new RuntimeException("Négociation non trouvée avec l'id " + negociationId));

        if (negociation.getIngenieurCivil() == null) {
            negociation.setIngenieurCivil(STATIC_ENGINEER);
            negociationRepository.save(negociation);
        }

        document.setNegociation(negociation);
        return documentNegociationRepository.save(document);
    }

    @Override
    public List<DocumentNegociation> listerDocumentsPhase3(Long negociationId) {
        return documentNegociationRepository.findByNegociationId(negociationId);
    }
}