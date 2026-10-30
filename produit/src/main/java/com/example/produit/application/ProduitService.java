package com.example.produit.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produit.infrastructure.ProduitRepository;
//permet à Spring d'initialiser cet objet et de le configurer
@Service
public class ProduitService {
//permet de récupérer l'instance de ProduitRepository dans Spring et de manipuler JPA à travers cette dernière
@Autowired
private ProduitRepository repo;

public List<Produit> getProduits() {
    return repo.findAll();
}

public List<Produit> getProduitsByIds(List<Integer> ids) {
    return repo.findAllById(ids);
}

public void saveProduit(Produit produit) {
    repo.save(produit);
}

public boolean deleteProduit(int id) {
    if (!repo.existsById(id)) {
        return false;
    }
    repo.deleteById(id);
    return true;
}

public Produit updateProduit(Produit produit) {
    if (!repo.existsById(produit.getId())) {
        return null;
    }
    return repo.save(produit);
}


}