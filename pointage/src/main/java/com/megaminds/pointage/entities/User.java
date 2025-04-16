package com.megaminds.pointage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @Column(name = "telephone", nullable = false)
    private Long telephone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore  // This breaks the circular reference
    private List<HistoriquePointage> historiquePointages;

    // Constructors
    public User() {}

    public User(byte[] image, Long telephone) {
        this.image = image;
        this.telephone = telephone;
    }

    // Getters and Setters
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

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public List<HistoriquePointage> getHistoriquePointages() {
        return historiquePointages;
    }

    public void setHistoriquePointages(List<HistoriquePointage> historiquePointages) {
        this.historiquePointages = historiquePointages;
    }

    // Helper method to expose just the pointage IDs if needed
    @Transient
    public List<Long> getHistoriquePointageIds() {
        return historiquePointages != null ?
                historiquePointages.stream().map(HistoriquePointage::getId).toList() :
                List.of();
    }
}