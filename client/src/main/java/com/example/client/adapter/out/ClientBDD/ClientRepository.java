// pour heriter des methodes de JPA pour récupérer des données en base
package com.example.client.adapter.out.ClientBDD;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClientRepository extends JpaRepository<ClientJPAEntity, Integer> {
}

