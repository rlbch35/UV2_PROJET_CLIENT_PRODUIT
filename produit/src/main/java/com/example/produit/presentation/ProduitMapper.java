package com.example.produit.presentation;

import com.example.produit.application.Produit;

public class ProduitMapper {
    public static ProduitDTO toDTO(Produit produit) {
        return new ProduitDTO(produit.getId(), produit.getNom(), produit.getDescription(), produit.getPrix());
    }

    public static Produit toEntity(ProduitDTO produitDTO) {
        return new Produit(produitDTO.getId(), produitDTO.getNom(), produitDTO.getDescription(), produitDTO.getPrix());
    }

    public static Produit toEntity(CreationProduitDTO creationProduitDTO) {
        return new Produit(creationProduitDTO.getNom(), creationProduitDTO.getDescription(), creationProduitDTO.getPrix());
    }

}
