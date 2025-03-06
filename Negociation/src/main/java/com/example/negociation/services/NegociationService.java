package com.example.negociation.services;

import com.example.negociation.entities.*;
import com.example.negociation.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegociationService {

    private final NegociationRepository negociationRepo;
    private final PhaseNegociationRepository phaseRepo;
    private final TacheNegociationRepository tacheRepo;
    private final DocumentNegociationRepository documentRepo;
    private final MessageNegociationRepository messageRepo;
    private final ContratNegociationRepository contratRepo;


    @Autowired
    public NegociationService(NegociationRepository negociationRepo, PhaseNegociationRepository phaseRepo, TacheNegociationRepository tacheRepo, DocumentNegociationRepository documentRepo, MessageNegociationRepository messageRepo, ContratNegociationRepository contratRepo) {
        this.negociationRepo = negociationRepo;
        this.phaseRepo = phaseRepo;
        this.tacheRepo = tacheRepo;
        this.documentRepo = documentRepo;
        this.messageRepo = messageRepo;
        this.contratRepo = contratRepo;

    }

    // CRUD
    public Negociation create(Negociation negociation) {
        negociation.setDateCreation(LocalDateTime.now());
        return negociationRepo.save(negociation);
    }

    public List<Negociation> findAll() {
        return negociationRepo.findAll();
    }

    public Negociation findById(Long id) {
        return negociationRepo.findById(id).orElseThrow();
    }

    public Negociation update(Negociation negociation) {
        return negociationRepo.save(negociation);
    }

    public void delete(Long id) {
        negociationRepo.deleteById(id);
    }

    // Gestion des phases
    public PhaseNegociation startPhase(Long negociationId, PhaseNegociation newPhase) {
        newPhase.setNegociationId(negociationId);
        return phaseRepo.save(newPhase);
    }

    public MessageNegociation save(MessageNegociation message) {
        message.setDateEnvoi(LocalDateTime.now());
        return messageRepo.save(message);
    }

    // Retrieve all negotiations with specified attributes
    public List<NegociationDTO> findAllNegotiations() {
        return negociationRepo.findAll().stream()
                .map(negociation -> new NegociationDTO(
                        negociation.getId(),
                        negociation.getClientId(),
                        negociation.getAdminId(),
                        negociation.getBudgetEstime(),
                        negociation.getExigences(),
                        negociation.getStatut(),
                        negociation.getDateCreation(),
                        negociation.getDateFin()))
                .collect(Collectors.toList());
    }

    // Retrieve negotiation details by ID
    public NegociationDTO findNegotiationById(Long id) {
        Negociation negociation = negociationRepo.findById(id).orElseThrow();
        return new NegociationDTO(
                negociation.getId(),
                negociation.getClientId(),
                negociation.getAdminId(),
                negociation.getBudgetEstime(),
                negociation.getExigences(),
                negociation.getStatut(),
                negociation.getDateCreation(),
                negociation.getDateFin());
    }
    public List<PhaseNegociation> findPhasesByClientId(Long clientId) {
        String status = "EN_COURS";
        List<Negociation> negociations = negociationRepo.findByClientId(clientId);
        return negociations.stream()
                .flatMap(negociation -> phaseRepo.findByNegociationIdAndStatut(negociation.getId(), status).stream())
                .collect(Collectors.toList());
    }
}