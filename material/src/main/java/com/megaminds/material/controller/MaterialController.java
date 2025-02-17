package com.megaminds.material.controller;

import com.megaminds.material.dto.MaterialPurchaseRequest;
import com.megaminds.material.dto.MaterialPurchaseResponse;
import com.megaminds.material.dto.MaterialRequest;
import com.megaminds.material.dto.MaterialResponse;
import com.megaminds.material.service.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials")
@RequiredArgsConstructor
public class MaterialController {
    private final MaterialService service;

    @PostMapping
    public ResponseEntity<Integer> createMaterial(
            @RequestBody @Valid MaterialRequest request
    ) {
        return ResponseEntity.ok(service.createMaterial(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<MaterialPurchaseResponse>> purchaseMaterials(
            @RequestBody List<MaterialPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseMaterials(request));
    }

    @GetMapping("/{material-id}")
    public ResponseEntity<MaterialResponse> findById(
            @PathVariable("material-id") Integer materialId
    ) {
        return ResponseEntity.ok(service.findById(materialId));
    }

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{material-id}")
    public ResponseEntity<MaterialResponse> updateMaterial(
            @PathVariable("material-id") Integer materialId,
            @RequestBody @Valid MaterialRequest request
    ) {
        return ResponseEntity.ok(service.updateMaterial(materialId, request));
    }

    @DeleteMapping("/{material-id}")
    public ResponseEntity<Void> deleteMaterial(
           @PathVariable("material-id") Integer materialId
    ) {
        service.deleteMaterial(materialId);
        return ResponseEntity.noContent().build();
    }

}
