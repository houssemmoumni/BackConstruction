package com.example.negociation.controllers;

import com.example.negociation.entities.Negociation;
import com.example.negociation.entities.NegociationDTO;
import com.example.negociation.entities.PhaseNegociation;
import com.example.negociation.services.NegociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/negociations")
public class NegociationController {
    private final NegociationService service;

    @Autowired
    public NegociationController(NegociationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Negociation> create(@RequestBody Negociation negociation) {
        return ResponseEntity.status(201).body(service.create(negociation));
    }

    @GetMapping
    public ResponseEntity<List<Negociation>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/all")
    public ResponseEntity<List<NegociationDTO>> findAllNegotiations() {
        return ResponseEntity.ok(service.findAllNegotiations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NegociationDTO> findNegotiationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findNegotiationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Negociation> update(@PathVariable Long id, @RequestBody Negociation negociation) {
        negociation.setId(id);
        return ResponseEntity.ok(service.update(negociation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idNegociation}/phases")
    public ResponseEntity<?> startPhase(
            @PathVariable Long idNegociation,
            @RequestBody PhaseNegociation newPhase) {
        // Validate nomPhase
        if (newPhase.getNomPhase() == null) {
            return ResponseEntity.badRequest().body("Invalid phase name");
        }

        // Get list of negotiation IDs
        List<Long> negociationIds = service.findAll().stream()
                .map(Negociation::getId)
                .collect(Collectors.toList());

        // Check if the provided idNegociation is valid
        if (!negociationIds.contains(idNegociation)) {
            return ResponseEntity.badRequest().body("Invalid negotiation ID");
        }

        // Start the phase
        PhaseNegociation savedPhase = service.startPhase(idNegociation, newPhase);
        return ResponseEntity.ok(savedPhase);
    }

    @GetMapping("/ids")
    public ResponseEntity<List<Long>> getAllNegociationIds() {
        List<Long> ids = service.findAll().stream()
                .map(Negociation::getId)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }
    @GetMapping("/client/{clientId}/phases")
    public ResponseEntity<List<PhaseNegociation>> findPhasesByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(service.findPhasesByClientId(clientId));
    }
}