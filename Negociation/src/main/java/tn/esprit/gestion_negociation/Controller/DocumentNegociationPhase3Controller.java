package tn.esprit.gestion_negociation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestion_negociation.Entity.DocumentNegociation;
import tn.esprit.gestion_negociation.Service.DocumentNegociationPhase3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/phase3/negociations/{negociationId}/documents")
public class DocumentNegociationPhase3Controller {

    @Autowired
    private DocumentNegociationPhase3Service documentPhase3Service;

    @PostMapping
    public ResponseEntity<DocumentNegociation> ajouterDocumentPhase3(
            @PathVariable Long negociationId,
            @RequestBody DocumentNegociation document) {
        DocumentNegociation savedDocument = documentPhase3Service.ajouterDocumentPhase3(negociationId, document);
        return ResponseEntity.ok(savedDocument);
    }


    @GetMapping
    public ResponseEntity<List<DocumentNegociation>> listerDocumentsPhase3(@PathVariable Long negociationId) {
        List<DocumentNegociation> documents = documentPhase3Service.listerDocumentsPhase3(negociationId);
        return ResponseEntity.ok(documents);
    }
}
