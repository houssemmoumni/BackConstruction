package com.example.negociation.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TacheNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomTache;
    private int responsableId;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutTache statut;

    private LocalDateTime dateCreation;
    private LocalDateTime dateValidation;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private PhaseNegociation phase;

    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL)
    private List<DocumentNegociation> documents = new ArrayList<>();

    public enum StatutTache {
        EN_ATTENTE, EN_COURS, VALIDE, REJETE
    }
}