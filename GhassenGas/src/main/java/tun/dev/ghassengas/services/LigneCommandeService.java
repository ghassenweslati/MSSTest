package tun.dev.ghassengas.services;

import org.springframework.stereotype.Service;
import tun.dev.ghassengas.entities.LigneCommande;
import tun.dev.ghassengas.entities.Produit;
import tun.dev.ghassengas.repositories.LigneCommandeRepository;
import tun.dev.ghassengas.repositories.ProduitRepository;

@Service
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;
    private final ProduitRepository produitRepository ;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository, ProduitRepository produitRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.produitRepository= produitRepository ;
    }

    public void ajoutLigneCommande(LigneCommande ligneCommande) {

        ligneCommandeRepository.save(ligneCommande);
    }

    public void deleteProduitFromLigneCommande(int produitId, int commandeId) {
        ligneCommandeRepository.deleteProduitFromLigneCommande(produitId, commandeId);

    }
}
