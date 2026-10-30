// interface des cas d'usage du microservice client 
// à implementer dans ClientPresentation 
package com.example.client.application.port.in;

import java.util.List;


import com.example.client.domain.Client;
public interface ClientUseCasePort {

    List<Client> listClients();

    Client getById(int id);

    void createClient(Client client);

    void deleteClient(int id);

    void updateClient(Client client);

    // List<Produit> listProduitsClient(int idClient);

    // void addProduitClient(int idClient, int idProduit);

    // void deleteProduitClient(int idClient, int idProduit);
}
