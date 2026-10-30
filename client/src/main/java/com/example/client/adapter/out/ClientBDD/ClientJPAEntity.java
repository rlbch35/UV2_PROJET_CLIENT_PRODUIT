// format table client en BDD 

package com.example.client.adapter.out.ClientBDD;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")

public class ClientJPAEntity { @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    private String prenom;
    private String email;
    private String telephone;

    @ElementCollection
    private List<Integer> idProduits = new ArrayList<>();

    public ClientJPAEntity() {
}

    public ClientJPAEntity(String nom, String prenom, String email, String telephone, List<Integer> idProduits) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.idProduits = new ArrayList<>(idProduits);
    }

    public ClientJPAEntity(int id, String nom, String prenom, String email, String telephone, List<Integer> idProduits) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.idProduits = new ArrayList<>(idProduits);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Integer> getIdProduits() {
        return idProduits;
    }
}