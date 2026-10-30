// règle métier, ce que peut faire le client
// implemente ClientUseCasePort
// implémente les règles métiers de l'application client en faisait appel a ClientRepositoryPort pour interroger la base client et ProduitPort pour interroger le microservice produit

package com.example.client.application.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.client.application.port.in.ClientUseCasePort;
import com.example.client.application.port.out.ClientRepositoryPort;
import com.example.client.domain.Client;

@Component
@Transactional 
public class ClientService implements ClientUseCasePort {
    @Autowired 
    private ClientRepositoryPort clientRepositoryPort;

    // lister tous les clients
    @Override
    public List<Client> listClients(){
        return clientRepositoryPort.findAll();
    }

    // récupérer les infos d'un client avec son id
    @Override
    public Client getById(int id){
        return clientRepositoryPort.getById(id);
    }
    // créer un nouveau client
    @Override
    public void createClient(Client client) {
        clientRepositoryPort.save(client);
    }

    //Supprimer un client
    @Override 
    public void deleteClient(int id){
        clientRepositoryPort.deleteById(id);
    }

    // modifier un client
    @Override
    public void updateClient(Client client) {
        clientRepositoryPort.save(client);
    }

}
