package tn.esprit.gestion_negociation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_negociation.Entity.Negociation;
import tn.esprit.gestion_negociation.Entity.NegociationLightDTO;
import tn.esprit.gestion_negociation.Service.NegociationService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/phase1/negociations")
public class NegociationController {

    @Autowired
    private NegociationService negociationService;


    @PostMapping("ADD{id}")
    public ResponseEntity<Negociation> creerNegociation(@RequestBody Negociation negociation, @PathVariable("id") Long id) {
        Negociation created = negociationService.creerNegociation(negociation,id);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Negociation> getNegociation(@PathVariable Long id) {
        Negociation negociation = negociationService.getNegociationById(id);
        return ResponseEntity.ok(negociation);
    }


    @GetMapping
    public ResponseEntity<List<Negociation>> listerNegociations() {
        List<Negociation> list = negociationService.listerNegociations();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/light")
    public ResponseEntity<List<NegociationLightDTO>> listerNegociationsLight() {
        List<NegociationLightDTO> list = negociationService.listerNegociationsLight();
        return ResponseEntity.ok(list);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Negociation> updateNegociation(@PathVariable Long id,
                                                         @RequestBody Negociation negociation) {
        Negociation updated = negociationService.updateNegociation(id, negociation);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNegociation(@PathVariable Long id) {
        negociationService.deleteNegociation(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/validation")
    public ResponseEntity<Negociation> validation(@PathVariable Long id,
                                                  @RequestParam boolean isValid,
                                                  @RequestParam(required = false) String comment) {
        Negociation validated = negociationService.validationNegociation(id, isValid, comment);
        return ResponseEntity.ok(validated);
    }
    @GetMapping("/light/{id}")
    public ResponseEntity<NegociationLightDTO> getNegociationLight(@PathVariable Long id) {
        NegociationLightDTO negociation = negociationService.getNegociationLightById(id);
        return ResponseEntity.ok(negociation);
    }

}
