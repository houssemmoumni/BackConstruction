package com.example.negociation.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ContratNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentPath;
    private LocalDateTime dateSignature;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    @OneToOne
    @JoinColumn(name = "negociation_id")
    private Negociation negociation;

    public enum StatutContrat {
        SIGNE, EN_ATTENTE, REFUSE
    }
}