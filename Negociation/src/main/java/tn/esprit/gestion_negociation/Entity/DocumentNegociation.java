package tn.esprit.gestion_negociation.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "document_negociations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String url;
    private String typeDocument;

    @ManyToOne
    @JoinColumn(name = "negociation_id")
    private Negociation negociation;

}
