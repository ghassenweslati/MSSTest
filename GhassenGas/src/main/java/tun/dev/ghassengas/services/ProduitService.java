package tun.dev.ghassengas.services;

import org.springframework.stereotype.Service;
import tun.dev.ghassengas.entities.Produit;
import tun.dev.ghassengas.repositories.CategorieRepository;
import tun.dev.ghassengas.repositories.ProduitRepository;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }


    public void ajoutProduit(Produit produit, int categorieId) {
        var categorie = categorieRepository.findById(categorieId).get();
        produit.setCategorie(categorie);
        produitRepository.save(produit);
    }

    public List<Produit> produitList() {
        return produitRepository.findAll();
    }

    public List<Produit> produitListInCategorie(int categorieId) {
        return produitRepository.findAllByCategorie(categorieId);
    }

    public void deleteProduit(int produitId) {
        produitRepository.deleteById(produitId);
    }


}
