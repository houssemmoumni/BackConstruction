// PhaseNegociation.java
package com.example.negociation.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class PhaseNegociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NomPhase nomPhase;
    private String statut;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "negociation_id", insertable = false, updatable = false)
    private Negociation negociation;

    @Column(name = "negociation_id")
    private Long negociationId;

    @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL)
    private List<TacheNegociation> taches = new ArrayList<>();

    // Getters and setters
    public Long getNegociationId() {
        return negociationId;
    }

    public void setNegociationId(Long negociationId) {
        this.negociationId = negociationId;
    }

    public NomPhase getNomPhase() {
        return nomPhase;
    }

    public void setNomPhase(NomPhase nomPhase) {
        this.nomPhase = nomPhase;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public enum NomPhase {
        CLIENT_ADMIN, CLIENT_ARCHITECTE, CLIENT_INGENIEUR
    }
}