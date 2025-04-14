package tn.esprit.gestion_negociation.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_negociations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageNegociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String contenu;

    private LocalDateTime dateEnvoi = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "negociation_id")
    private Negociation negociation;
}