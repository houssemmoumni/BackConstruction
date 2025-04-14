package tn.esprit.gestion_negociation.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "negociations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Negociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String demande;
    private BigDecimal budgetEstime;
    private String exigences;

    @Enumerated(EnumType.STRING)
    private StatusNegociation status;

    @Enumerated(EnumType.STRING)
    private PhaseNegociation phase;

    private LocalDateTime dateCreation = LocalDateTime.now();
    private LocalDateTime dateModification = LocalDateTime.now();

    @OneToMany(mappedBy = "negociation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageNegociation> messages = new ArrayList<>();

    @OneToMany(mappedBy = "negociation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentNegociation> documents = new ArrayList<>();

    @OneToOne(mappedBy = "negociation", cascade = CascadeType.ALL)
    private ContratNegociation contrat;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "architecte_id")
    private User architecte;

    @ManyToOne
    @JoinColumn(name = "ingenieur_civil_id")
    private User ingenieurCivil;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User administrateur;
}
