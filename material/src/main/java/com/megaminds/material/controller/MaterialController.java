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
            @RequestParam Integer userId,
            @RequestBody @Valid MaterialRequest request
    ) {
        return ResponseEntity.ok(service.createMaterial(userId,request));
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
            @RequestParam Integer userId,  // Get userId from request param
            @PathVariable("material-id") Integer materialId,
            @RequestBody @Valid MaterialRequest request
    ) {
        return ResponseEntity.ok(service.updateMaterial(userId,materialId, request));
    }

    @DeleteMapping("/{material-id}")
    public ResponseEntity<Void> deleteMaterial(
            @RequestParam Integer userId,  // Get userId from request param
           @PathVariable("material-id") Integer materialId
    ) {
        service.deleteMaterial(userId,materialId);
        return ResponseEntity.noContent().build();
    }

}
