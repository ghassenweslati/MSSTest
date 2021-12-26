package tun.dev.ghassengas.controllers;

import org.springframework.web.bind.annotation.*;
import tun.dev.ghassengas.entities.Commande;
import tun.dev.ghassengas.entities.LigneCommande;
import tun.dev.ghassengas.repositories.CommandeRepository;
import tun.dev.ghassengas.repositories.ProduitRepository;
import tun.dev.ghassengas.services.LigneCommandeService;

import java.math.BigDecimal;

@RestController
@CrossOrigin("*")
@RequestMapping("/LigneCommande")

public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;

    public LigneCommandeController(LigneCommandeService ligneCommandeService, CommandeRepository commandeRepository, ProduitRepository produitRepository) {
        this.ligneCommandeService = ligneCommandeService;
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
    }

    @PostMapping("/ajoutLigneCommande/{commandeId}/{produitId}")
    public void ajoutLigneCommande(@RequestBody LigneCommande ligneCommande, @PathVariable int commandeId, @PathVariable int produitId) {
        Commande command = commandeRepository.findById(commandeId).get();
        ligneCommande.setCommande(command);
        var produit = produitRepository.findById(produitId).get();
        ligneCommande.setProduit(produit);
        ligneCommande.setPrixUnitaire(produit.getPrixUnitaire());
        var quantite = new BigDecimal(ligneCommande.getQte());
        BigDecimal prixTotal = quantite.multiply(ligneCommande.getPrixUnitaire());
        ligneCommande.setPrixTotal(prixTotal);
        ligneCommandeService.ajoutLigneCommande(ligneCommande);
    }

    @DeleteMapping("/deleteProduitFromLigneCommande/{produitId}/{commandeId}")
    public void deleteProduitFromLigneCommande(@PathVariable int produitId, @PathVariable int commandeId) {
        ligneCommandeService.deleteProduitFromLigneCommande(produitId, commandeId);
    }


}
