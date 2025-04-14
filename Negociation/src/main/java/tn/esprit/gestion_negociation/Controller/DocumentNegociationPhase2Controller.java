package tn.esprit.gestion_negociation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_negociation.Entity.DocumentNegociation;
import tn.esprit.gestion_negociation.Service.DocumentNegociationPhase2Service;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/phase2/negociations/{negociationId}/documents")
public class DocumentNegociationPhase2Controller {

    @Autowired
    private DocumentNegociationPhase2Service documentPhase2Service;


    @PostMapping
    public ResponseEntity<DocumentNegociation> ajouterDocumentPhase2(
            @PathVariable Long negociationId,
            @RequestBody DocumentNegociation document) {
        DocumentNegociation savedDocument = documentPhase2Service.ajouterDocumentPhase2(negociationId, document);
        return ResponseEntity.ok(savedDocument);
    }

    @GetMapping
    public ResponseEntity<List<DocumentNegociation>> listerDocumentsPhase2(@PathVariable Long negociationId) {
        List<DocumentNegociation> documents = documentPhase2Service.listerDocumentsPhase2(negociationId);
        return ResponseEntity.ok(documents);
    }
}