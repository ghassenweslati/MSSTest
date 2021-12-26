package tun.dev.ghassengas.controllers;

import org.springframework.web.bind.annotation.*;
import tun.dev.ghassengas.entities.Commande;
import tun.dev.ghassengas.entities.Produit;
import tun.dev.ghassengas.services.CommandeService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Commande")

public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping("/ajouterCommande/{idClient}")
    public void ajouterCommande(@RequestBody Commande commande, @PathVariable int idClient) {
        commandeService.ajouterCommande(commande, idClient);
    }
	@GetMapping("/listeProduitsDansCommande/{commandeId}")
    public List<Produit> listeProduitsDansCommande(@PathVariable int commandeId){

        return commandeService.listeProduitsDansCommande(commandeId) ;
    }

    @PutMapping("/validerCommande/{idCommande}")
    public void validerCommande(@PathVariable int idCommande) {
        commandeService.validerCommande(idCommande);
    }
	
	
}
