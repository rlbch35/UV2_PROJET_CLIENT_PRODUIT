// interface des actions pouvant être menées sur la BDD client
package com.example.client.application.port.out;

import java.util.List;

import com.example.client.domain.Client;


public interface ClientRepositoryPort {
    // //lister tous les clients
    List<Client> findAll();

    // récupérer les infos d'un client
    Client getById(int id);

    //ajouter un client
    void save(Client client);

    // // supprimer un client à l'aide de son id
    void deleteById(int id);

    // // modifier un client

    // //lister les produits d'un client (== visu panier)
    // List<Produit> listProduitsClient(int idClient);

    // //ajouter un produit (== ajouter au panier)
    // void addProduitClient(int idClient, int idProduit);

    // //supprimer un produit (== retirer du panier)
    // void deleteProduitClient(int idClient, int idProduit);
    
}
