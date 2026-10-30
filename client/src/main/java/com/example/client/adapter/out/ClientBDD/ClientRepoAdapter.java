// Implementation de ClientRepository port qui comporte les actions pouvant être mener sur la BDD client
// fait la conversione entre client et clientJPAEntity
package com.example.client.adapter.out.ClientBDD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.client.application.port.out.ClientRepositoryPort;
import com.example.client.domain.Client;

@Component
public class ClientRepoAdapter implements ClientRepositoryPort {

    @Autowired 
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        List<ClientJPAEntity> jpaEntities = clientRepository.findAll();
        List<Client> clients = new ArrayList<>();
        for (ClientJPAEntity entity : jpaEntities) {
        Client client = new Client(entity.getId(),entity.getNom(),entity.getPrenom(),entity.getEmail(),entity.getTelephone(), new ArrayList<>(entity.getIdProduits()));
        clients.add(client);
    }
    return clients;
    }

    @Override
    public void save(Client client) {
        ClientJPAEntity jpaEntity = new ClientJPAEntity(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), client.getIdProduits());
        ClientJPAEntity savedEntity = clientRepository.save(jpaEntity);
        client.setId(savedEntity.getId());
    }

    @Override
    public Client getById(int id){
        Optional<ClientJPAEntity> optJpaEntity = clientRepository.findById(id);
        ClientJPAEntity jpaEntity = optJpaEntity.get();
        return new Client(jpaEntity.getId(), jpaEntity.getNom(), jpaEntity.getPrenom(), jpaEntity.getEmail(), jpaEntity.getTelephone(), new ArrayList<>(jpaEntity.getIdProduits()));
    }
    // @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }


}
