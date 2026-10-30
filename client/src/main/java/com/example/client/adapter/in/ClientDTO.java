package com.example.client.adapter.in;

import java.util.List;

public class ClientDTO {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private List<Integer> idProduits;

    public ClientDTO(int id, String nom, String prenom, String email, String telephone,
            List<Integer> idProduits) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.idProduits = idProduits;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}