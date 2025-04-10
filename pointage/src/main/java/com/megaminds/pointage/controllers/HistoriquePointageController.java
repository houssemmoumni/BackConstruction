package com.megaminds.pointage.controllers;

import com.megaminds.pointage.entities.HistoriquePointage;
import com.megaminds.pointage.services.HistoriquePointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique-pointages")
public class HistoriquePointageController {

    @Autowired
    private HistoriquePointageService historiquePointageService;

    @GetMapping("/{id}")
    public HistoriquePointage getHistoriquePointage(@PathVariable Long id) {
        return historiquePointageService.getHistoriquePointageById(id);
    }

    @GetMapping
    public List<HistoriquePointage> getAllHistoriquePointages() {
        return historiquePointageService.getAllHistoriquePointages();
    }

    @PostMapping
    public HistoriquePointage createHistoriquePointage(@RequestBody HistoriquePointage historiquePointage) {
        return historiquePointageService.createHistoriquePointage(historiquePointage);
    }

    @PutMapping("/{id}")
    public HistoriquePointage updateHistoriquePointage(@PathVariable Long id, @RequestBody HistoriquePointage historiquePointage) {
        return historiquePointageService.updateHistoriquePointage(id, historiquePointage);
    }

    @DeleteMapping("/{id}")
    public void deleteHistoriquePointage(@PathVariable Long id) {
        historiquePointageService.deleteHistoriquePointage(id);
    }
}
