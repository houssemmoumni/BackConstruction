package tn.esprit.gestion_negociation.Entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class NegociationLightDTO {
    private Long id;
    private BigDecimal budgetEstime;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private String demande;
    private String exigences;
    private PhaseNegociation phase;
    private StatusNegociation status;
    private Long adminId;
    private Long architecteId;
    private Long clientId;
    private Long ingenieurCivilId;

    // Add this constructor
    public NegociationLightDTO(
            Long id,
            BigDecimal budgetEstime,
            LocalDateTime dateCreation,
            LocalDateTime dateModification,
            String demande,
            String exigences,
            PhaseNegociation phase,
            StatusNegociation status,
            Long adminId,
            Long architecteId,
            Long clientId,
            Long ingenieurCivilId) {
        this.id = id;
        this.budgetEstime = budgetEstime;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.demande = demande;
        this.exigences = exigences;
        this.phase = phase;
        this.status = status;
        this.adminId = adminId;
        this.architecteId = architecteId;
        this.clientId = clientId;
        this.ingenieurCivilId = ingenieurCivilId;
    }
}