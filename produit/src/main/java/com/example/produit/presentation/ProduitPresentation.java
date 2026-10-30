package com.example.produit.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.produit.application.Produit;
import com.example.produit.application.ProduitService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("produit")
public class ProduitPresentation {
    @Autowired
    private ProduitService produitService;
    @GET
    @Produces("application/json")
    public List<ProduitDTO> getProduits(@QueryParam("idProduit") List<Integer> idProduits){
    //ne pas oublier de mapper les donnÃ©es :)
    ProduitMapper pm = new ProduitMapper();
    List<Produit> produitsBdd;
    if(idProduits == null || idProduits.isEmpty()){
    produitsBdd = produitService.getProduits();
    }else{
    produitsBdd = produitService.getProduitsByIds(idProduits);
    }
    List<ProduitDTO> produitsRetournees = new ArrayList<>();
    //dans cette partie, on transforme les donnÃ©es en ProduitDTO
    for(Produit p : produitsBdd){
    produitsRetournees.add(pm.toDTO(p));
    }
    return produitsRetournees;
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createProduit(ProduitDTO produitDTO) {
        Produit produit = ProduitMapper.toEntity(new CreationProduitDTO( produitDTO.getNom(), produitDTO.getDescription(), produitDTO.getPrix()));
        produitService.saveProduit(produit);
        return Response.status(Response.Status.CREATED).entity(ProduitMapper.toDTO(produit)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduit(@PathParam("id") int id) {
        if (!produitService.deleteProduit(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response updateProduit(@PathParam("id") int id, ProduitDTO produitDTO) {
        Produit produit = new Produit(id, produitDTO.getNom(), produitDTO.getDescription(), produitDTO.getPrix());
        Produit updated = produitService.updateProduit(produit);
        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(ProduitMapper.toDTO(updated)).build();
    }
    


}
