package com.example.produit.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.produit.application.Produit;
//permet à Spring de créer l'objet et de le configurer correctement
@Component
//ici on indique à JPARepository qu'on manipule des objets Produit
//et ces derniers possèdent un identifiant en format entier
public interface ProduitRepository extends JpaRepository<Produit, Integer>{
}
