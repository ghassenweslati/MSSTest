package tun.dev.ghassengas.services;

import org.springframework.stereotype.Service;
import tun.dev.ghassengas.entities.Commande;
import tun.dev.ghassengas.entities.LigneCommande;
import tun.dev.ghassengas.entities.Produit;
import tun.dev.ghassengas.repositories.ClientRepository;
import tun.dev.ghassengas.repositories.CommandeRepository;
import tun.dev.ghassengas.repositories.LigneCommandeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    public CommandeService(CommandeRepository commandeRepository, ClientRepository clientRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public void ajouterCommande(Commande commande, int idClient) {
        var client = clientRepository.findById(idClient).get();
        commande.setClient(client);
        commandeRepository.save(commande);
    }

    public void validerCommande(int idCommande) {
        var commande = commandeRepository.findById(idCommande).get();
        List<LigneCommande> ligneCommande = ligneCommandeRepository.findByCommandeId(idCommande);
        double d = 0.0;
        for (LigneCommande element : ligneCommande) {
            d += element.getPrixTotal().doubleValue();
        }
        commande.setPrixTotal(new BigDecimal(d));
        commande.setDate(LocalDate.now());
        commandeRepository.save(commande);
    }

public List<Produit> listeProduitsDansCommande(int commandeId) {
        return  produitRepository.listeProduitsDansCommande(commandeId);
    }
}
