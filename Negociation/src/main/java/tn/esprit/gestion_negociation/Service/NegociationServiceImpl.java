package tn.esprit.gestion_negociation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_negociation.Entity.*;
import tn.esprit.gestion_negociation.Repository.NegociationRepository;
import tn.esprit.gestion_negociation.Repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NegociationServiceImpl implements NegociationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NegociationRepository negociationRepository;

    private static User STATIC_CLIENT = new User();
    private final static User STATIC_ADMIN = new User(2L, "Admin", "Static", "admin@example.com", "password", Role.ADMIN);

   
    @Override
    public Negociation creerNegociation(Negociation negociation, Long id) {
        STATIC_CLIENT = getUserById(id);
        negociation.setClient(STATIC_CLIENT);
        negociation.setStatus(StatusNegociation.EN_ATTENTE);
        negociation.setPhase(PhaseNegociation.CLIENT_ADMIN);
        negociation.setDateCreation(LocalDateTime.now());
        negociation.setDateModification(LocalDateTime.now());

        // Les champs exigences, budgetEstime et demande seront automatiquement
        // renseignés dans l'objet 'negociation' si le JSON envoyé par le client
        // contient ces clés et que l'entité Negociation possède les attributs
        // correspondants avec les getters et setters appropriés.

        // Exemple si vous souhaitez effectuer une validation supplémentaire :
        if (negociation.getExigences() == null || negociation.getExigences().isEmpty()) {
            throw new IllegalArgumentException("Le champ exigences est obligatoire.");
        }
        if (negociation.getBudgetEstime() == null) {
            throw new IllegalArgumentException("Le champ budgetEstime est obligatoire.");
        }
        if (negociation.getDemande() == null || negociation.getDemande().isEmpty()) {
            throw new IllegalArgumentException("Le champ demande est obligatoire.");
        }

        return negociationRepository.save(negociation);
    }




    @Override
    public Negociation getNegociationById(Long id) {
        return negociationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Négociation non trouvée avec l'id " + id));
    }

    @Override
    public List<Negociation> listerNegociations() {
        return negociationRepository.findAll();
    }

    @Override
    public Negociation updateNegociation(Long id, Negociation negociation) {
        Negociation existing = getNegociationById(id);
        existing.setDemande(negociation.getDemande());
        existing.setBudgetEstime(negociation.getBudgetEstime());
        existing.setExigences(negociation.getExigences());
        existing.setStatus(negociation.getStatus());
        existing.setPhase(negociation.getPhase());
        existing.setDateModification(LocalDateTime.now());
        return negociationRepository.save(existing);
    }

    @Override
    public void deleteNegociation(Long id) {
        negociationRepository.deleteById(id);
    }

    @Override
    public Negociation validationNegociation(Long id, boolean isValid, String comment) {
        Negociation neg = getNegociationById(id);
        neg.setAdministrateur(STATIC_ADMIN);
        if (isValid) {
            neg.setStatus(StatusNegociation.VALIDEE);
        } else {
            neg.setStatus(StatusNegociation.REFUSEE);
        }
        neg.setDateModification(LocalDateTime.now());
        return negociationRepository.save(neg);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id " + id));
    }

    public List<NegociationLightDTO> listerNegociationsLight() {
        return negociationRepository.findAllLight();
    }
    public NegociationLightDTO getNegociationLightById(Long id) {
        return negociationRepository.findLightById(id)
                .orElseThrow(() -> new RuntimeException("Négociation non trouvée avec l'ID : " + id));
    }

}