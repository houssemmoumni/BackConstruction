package tn.esprit.gestion_negociation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_negociation.Entity.ContratNegociation;
import tn.esprit.gestion_negociation.Entity.Negociation;
import tn.esprit.gestion_negociation.Repository.ContratNegociationRepository;
import tn.esprit.gestion_negociation.Repository.NegociationRepository;

import java.time.LocalDateTime;

@Service
public class ContratNegociationServiceImpl implements ContratNegociationService {

    @Autowired
    private ContratNegociationRepository contratNegociationRepository;

    @Autowired
    private NegociationRepository negociationRepository;


    @Override
    public ContratNegociation genererContrat(Long negociationId, String contenu) {
        Negociation negociation = negociationRepository.findById(negociationId)
                .orElseThrow(() -> new RuntimeException("Négociation non trouvée avec l'id " + negociationId));

        ContratNegociation contrat = new ContratNegociation();
        contrat.setContenu(contenu);
        contrat.setDateSignature(LocalDateTime.now());
        contrat.setNegociation(negociation);

        return contratNegociationRepository.save(contrat);
    }


    @Override
    public ContratNegociation getContratByNegociationId(Long negociationId) {
        return contratNegociationRepository.findByNegociationId(negociationId);
    }
}
