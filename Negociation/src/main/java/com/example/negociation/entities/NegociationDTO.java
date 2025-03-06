// NegociationDTO.java
package com.example.negociation.entities;

import java.time.LocalDateTime;

public class NegociationDTO {
    private Long id;
    private int clientId;
    private int adminId;
    private Float budgetEstime;
    private String exigences;
    private String statut;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFin;

    public NegociationDTO(Long id, int clientId, int adminId, Float budgetEstime, String exigences, String statut, LocalDateTime dateCreation, LocalDateTime dateFin) {
        this.id = id;
        this.clientId = clientId;
        this.adminId = adminId;
        this.budgetEstime = budgetEstime;
        this.exigences = exigences;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
    }

    // Getters and setters
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
}