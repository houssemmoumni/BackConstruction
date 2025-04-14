package tn.esprit.gestion_negociation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_negociation.Entity.ContratNegociation;
import tn.esprit.gestion_negociation.Service.ContratNegociationService;

@RestController
@CrossOrigin("http://localhost:4200")

@RequestMapping("/api/phase3/negociations/{negociationId}/contrat")
public class ContratNegociationPhase3Controller {

    @Autowired
    private ContratNegociationService contratNegociationService;


    @PostMapping
    public ResponseEntity<ContratNegociation> genererContrat(
            @PathVariable Long negociationId,
            @RequestParam String contenu) {
        ContratNegociation contrat = contratNegociationService.genererContrat(negociationId, contenu);
        return ResponseEntity.ok(contrat);
    }


    @GetMapping
    public ResponseEntity<ContratNegociation> getContrat(@PathVariable Long negociationId) {
        ContratNegociation contrat = contratNegociationService.getContratByNegociationId(negociationId);
        return ResponseEntity.ok(contrat);
    }
}
