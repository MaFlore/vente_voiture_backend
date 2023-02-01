package com.projet.classe.vente.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "marques")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "libelle")
    private String libelle;

    /*Relation OneToMany entre Marque et Voiture*/
    /*@OneToMany(mappedBy = "marque", fetch = FetchType.LAZY)
    private Set<Voiture> voitures;*/

    public Marque() {
    }

    public Marque(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
