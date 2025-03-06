package com.example.negociation.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Negociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int clientId;
    private int adminId;
    private Float budgetEstime;
    private String exigences;
    private String statut;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFin;

    @OneToMany(mappedBy = "negociation", cascade = CascadeType.ALL)
    private List<PhaseNegociation> phases = new ArrayList<>();

    @OneToMany(mappedBy = "negociation", cascade = CascadeType.ALL)
    private List<MessageNegociation> messages = new ArrayList<>();

    @OneToOne(mappedBy = "negociation", cascade = CascadeType.ALL)
    private ContratNegociation contrat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Float getBudgetEstime() {
        return budgetEstime;
    }

    public void setBudgetEstime(Float budgetEstime) {
        this.budgetEstime = budgetEstime;
    }

    public String getExigences() {
        return exigences;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public List<PhaseNegociation> getPhases() {
        return phases;
    }

    public void setPhases(List<PhaseNegociation> phases) {
        this.phases = phases;
    }

    public List<MessageNegociation> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageNegociation> messages) {
        this.messages = messages;
    }

    public ContratNegociation getContrat() {
        return contrat;
    }

    public void setContrat(ContratNegociation contrat) {
        this.contrat = contrat;
    }
}
