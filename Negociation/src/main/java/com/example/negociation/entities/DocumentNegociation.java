package com.example.negociation.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class DocumentNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomFichier;
    private String cheminFichier;

    @Enumerated(EnumType.STRING)
    private TypeDocument typeDocument;

    private LocalDateTime dateUpload;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private TacheNegociation tache;

    public enum TypeDocument {
        PLAN, CONTRAT, ESQUISSE
    }
}