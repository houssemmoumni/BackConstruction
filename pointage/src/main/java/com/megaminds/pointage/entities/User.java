package com.megaminds.pointage.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Stockage en BLOB dans la base de données
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    // Relation OneToMany avec HistoriquePointage
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<HistoriquePointage> historiquePointages; // Liste des historiques de pointage associés à l'utilisateur

    // Constructeurs
    public User() {}

    public User(byte[] image) {
        this.image = image;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<HistoriquePointage> getHistoriquePointages() {
        return historiquePointages;
    }

    public void setHistoriquePointages(List<HistoriquePointage> historiquePointages) {
        this.historiquePointages = historiquePointages;
    }
}
