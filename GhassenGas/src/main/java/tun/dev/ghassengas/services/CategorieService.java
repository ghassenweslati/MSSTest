package tun.dev.ghassengas.services;


import org.springframework.stereotype.Service;
import tun.dev.ghassengas.entities.Categorie;
import tun.dev.ghassengas.repositories.CategorieRepository;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository ;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public void ajoutCategorie(Categorie categorie){
        categorieRepository.save(categorie) ;
}

    public List<Categorie> categorieList() {
        return  categorieRepository.findAll();
    }
}
