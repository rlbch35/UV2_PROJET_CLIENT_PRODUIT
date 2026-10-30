// receptionne les requêtes HTTP GET/POST/PUT/DELETE fait avec POSTMAN
// Utilise ClientMapper pour la trad format WEB/ format Métier
// Utilise CLientUseCasePort --> client Service 
package com.example.client.adapter.in;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.client.application.port.in.ClientUseCasePort;
import com.example.client.domain.Client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Component
@Path("clients")
@Produces("application/json")
public class ClientPresentation {
    @Autowired
    private ClientUseCasePort clientUseCasePort;

    // récupérer la liste des clients
    @GET
    public List<ClientDTO> listClients() {
    List<Client> domainClients = clientUseCasePort.listClients();
        List<ClientDTO> clientList = new ArrayList<>();
        for (Client client : domainClients) {
                ClientDTO clientDto = ClientRestMapper.toDto(client);
                clientList.add(clientDto);
    }
        return clientList;
}
    //récupérer les infos d'un client
    @GET
    @Path("{id}")
    public Client getById(@PathParam("id") int id){
        return clientUseCasePort.getById(id);
    }
    // créer un nouveau client en passant par un DTO de création
    @POST
    @Consumes("application/json")
    public Response createClient(CreationClientDTO clientDTO) {
        Client client = ClientRestMapper.toDomain(clientDTO);
        clientUseCasePort.createClient(client);
        return Response.status(Response.Status.CREATED).entity(client).build(); // on renvoi un message 201 created si ok https://tomee.apache.org/jakartaee-9.0/javadoc/jakarta/ws/rs/core/Response.Status.html
    }

    //supprimer un client avec son id 
    @DELETE
    @Path("{id}")
    public Response deleteClient(@PathParam("id") int id) {
        clientUseCasePort.deleteClient(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    // modifier un client
    @PUT
    @Path("{id}")
    public Response updateClient(@PathParam("id") int id, ClientDTO clientDTO) {
        Client client = ClientRestMapper.toDomain(clientDTO);
        client.setId(id);
        clientUseCasePort.updateClient(client);
        return Response.status(Response.Status.CREATED).entity(client).build(); // on renvoi un message 201 created si ok https://tomee.apache.org/jakartaee-9.0/javadoc/jakarta/ws/rs/core/Response.Status.html
    }


    // Ajouter un produit à un client
    //@POST

    // Supprimer un produit à un client 
    //@DELETE
}