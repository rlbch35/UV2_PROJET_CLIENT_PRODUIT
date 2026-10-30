package com.example.client.application.port.out;

public interface ProduitPort {
    //Contrôler si le produits existe dans le microservices Produit
    boolean produitExists (int idProduit);
}
