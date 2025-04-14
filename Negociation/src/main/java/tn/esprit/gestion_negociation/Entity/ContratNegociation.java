package tn.esprit.gestion_negociation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrat_negociations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String contenu;

    private LocalDateTime dateSignature = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "negociation_id")
    private Negociation negociation;
}
