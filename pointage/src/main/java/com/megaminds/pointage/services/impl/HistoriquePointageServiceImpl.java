package com.megaminds.pointage.services.impl;

import com.megaminds.pointage.entities.HistoriquePointage;
import com.megaminds.pointage.repositories.HistoriquePointageRepository;
import com.megaminds.pointage.services.HistoriquePointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class HistoriquePointageServiceImpl implements HistoriquePointageService {

    @Autowired
    private HistoriquePointageRepository historiquePointageRepository;

    @Override
    public HistoriquePointage getHistoriquePointageById(Long id) {
        return historiquePointageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HistoriquePointage not found with id " + id));
    }

    @Override
    public List<HistoriquePointage> getAllHistoriquePointages() {
        return historiquePointageRepository.findAll();
    }

    @Override
    public HistoriquePointage createHistoriquePointage(HistoriquePointage historiquePointage) {
        validateDates(historiquePointage); // Vérifier les dates avant l'ajout
        historiquePointage.setScore(calculateScore(historiquePointage)); // Calcul automatique du score
        return historiquePointageRepository.save(historiquePointage);
    }

    @Override
    public HistoriquePointage updateHistoriquePointage(Long id, HistoriquePointage historiquePointage) {
        return historiquePointageRepository.findById(id).map(existingHistoriquePointage -> {
            // Appliquer les mises à jour
            if (historiquePointage.getJourPointage() != null) {
                existingHistoriquePointage.setJourPointage(historiquePointage.getJourPointage());
            }
            if (historiquePointage.getTempsEntree() != null) {
                existingHistoriquePointage.setTempsEntree(historiquePointage.getTempsEntree());
            }
            if (historiquePointage.getTempsSortie() != null) {
                existingHistoriquePointage.setTempsSortie(historiquePointage.getTempsSortie());
            }
            if (historiquePointage.getLocalisation() != null) {
                existingHistoriquePointage.setLocalisation(historiquePointage.getLocalisation());
            }
            if (historiquePointage.getUser() != null) {
                existingHistoriquePointage.setUser(historiquePointage.getUser());
            }
            if (historiquePointage.getTempsCommencement() != null) {
                existingHistoriquePointage.setTempsCommencement(historiquePointage.getTempsCommencement());
            }
            if (historiquePointage.getTempsFinition() != null) {
                existingHistoriquePointage.setTempsFinition(historiquePointage.getTempsFinition());
            }

            // Vérifier les dates après mise à jour
            validateDates(existingHistoriquePointage);

            // Recalcul du score
            existingHistoriquePointage.setScore(calculateScore(existingHistoriquePointage));

            return historiquePointageRepository.save(existingHistoriquePointage);
        }).orElseThrow(() -> new RuntimeException("HistoriquePointage not found with id " + id));
    }

    @Override
    public void deleteHistoriquePointage(Long id) {
        if (!historiquePointageRepository.existsById(id)) {
            throw new RuntimeException("HistoriquePointage not found with id " + id);
        }
        historiquePointageRepository.deleteById(id);
    }

    /**
     * Vérifie la validité des dates (entrée et sortie doivent respecter les contraintes).
     */
    private void validateDates(HistoriquePointage historiquePointage) {
        LocalTime tempsEntree = historiquePointage.getTempsEntree();
        LocalTime tempsSortie = historiquePointage.getTempsSortie();
        LocalTime tempsCommencement = historiquePointage.getTempsCommencement();
        LocalTime tempsFinition = historiquePointage.getTempsFinition();

        if (tempsEntree == null || tempsSortie == null || tempsCommencement == null || tempsFinition == null) {
            throw new IllegalArgumentException("Toutes les dates doivent être renseignées.");
        }

        // Vérifier que l'entrée est entre le commencement et la sortie
        if (tempsEntree.isBefore(tempsCommencement) || tempsEntree.isAfter(tempsSortie)) {
            throw new IllegalArgumentException("L'heure d'entrée doit être entre l'heure de commencement et l'heure de sortie.");
        }

        // Vérifier que la sortie est entre l'entrée et la fin prévue
        if (tempsSortie.isBefore(tempsEntree) || tempsSortie.isAfter(tempsFinition)) {
            throw new IllegalArgumentException("L'heure de sortie doit être entre l'heure d'entrée et l'heure de finition.");
        }
    }

    /**
     * Calcule le score en fonction du retard à l'entrée et de la sortie anticipée.
     */
    private int calculateScore(HistoriquePointage historiquePointage) {
        LocalTime tempsEntree = historiquePointage.getTempsEntree();
        LocalTime tempsSortie = historiquePointage.getTempsSortie();
        LocalTime tempsCommencement = historiquePointage.getTempsCommencement();
        LocalTime tempsFinition = historiquePointage.getTempsFinition();

        int scoreMax = 100; // Score optimal si l'ouvrier est à l'heure
        int penaltyPer3Minutes = 1; // Pénalité de 1 point par tranche de 3 minutes de retard ou sortie anticipée

        // Calcul du retard à l'entrée
        long minutesLate = Duration.between(tempsCommencement, tempsEntree).toMinutes();
        if (minutesLate > 0) {
            scoreMax -= (int) (minutesLate / 3) * penaltyPer3Minutes;
        }

        // Calcul de la sortie anticipée
        long minutesEarly = Duration.between(tempsSortie, tempsFinition).toMinutes();
        if (minutesEarly > 0) {
            scoreMax -= (int) (minutesEarly / 3) * penaltyPer3Minutes;
        }

        // Si le score est négatif, on le ramène à 0
        return Math.max(scoreMax, 0);
    }
}
