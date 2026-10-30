package com.example.client.adapter.in;

import java.util.ArrayList;

import com.example.client.domain.Client;
/**
 * Traducteur entre les objets web (DTOs) et le domaine.
 */
public class ClientRestMapper {

    /**
     * Transforme le DTO de création en objet du domaine vierge.
     */
    public static Client toDomain(CreationClientDTO dto) {
        if (dto == null) return null;
        return new Client(dto.getNom(),dto.getPrenom(),dto.getEmail(),dto.getTelephone(),new ArrayList<>()
        );
    }

    /**
     * Transforme le modèle du domaine en DTO de lecture pour l'API.
     */
    public static ClientDTO toDto(Client domain) {
        if (domain == null) return null;
        return new ClientDTO(domain.getId(),domain.getNom(),domain.getPrenom(),domain.getEmail(),domain.getTelephone(),domain.getIdProduits()
        );
    }

    public static Client toDomain(ClientDTO dto) {
        return new Client(dto.getId(), dto.getNom(),dto.getPrenom(),dto.getEmail(),dto.getTelephone(),dto.getIdProduits());
    }

}