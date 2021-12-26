package tun.dev.ghassengas.controllers;

import org.springframework.web.bind.annotation.*;
import tun.dev.ghassengas.entities.Produit;
import tun.dev.ghassengas.services.ProduitService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Produit")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    //ajouter un produit en spécifiant l'id du catégorie
    @PostMapping("/ajoutProduit/{categorieId}")
    public void ajoutProduit(@RequestBody Produit produit, @PathVariable int categorieId) {
        produitService.ajoutProduit(produit, categorieId);
    }

    //Afficher la liste des produits
    @GetMapping("/listProduits")
    public List<Produit> produitList() {
        return produitService.produitList();
    }

    //Afficher la liste des produits dans une catégorie
    @GetMapping("/listProduitsInCategorie/{categorieId}")
    public List<Produit> produitListInCategorie(@PathVariable int categorieId){
        return produitService.produitListInCategorie(categorieId) ;

    }

    //Supprimer un produite par Id
    @DeleteMapping("/deleteProduit/{produitId}")
    public void deleteProduit(@PathVariable int produitId) {
        produitService.deleteProduit(produitId);
    }

}
