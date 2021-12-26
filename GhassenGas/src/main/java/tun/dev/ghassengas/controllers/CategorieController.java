package tun.dev.ghassengas.controllers;

import org.springframework.web.bind.annotation.*;
import tun.dev.ghassengas.entities.Categorie;
import tun.dev.ghassengas.services.CategorieService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Categorie")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    //Ajouter une catégorie
    @PostMapping("/ajoutCategorie")
    public void ajoutCategorie(@RequestBody Categorie categorie) {
        categorieService.ajoutCategorie(categorie);
    }

    //Afficher la liste des catégories
    @GetMapping("/listCategories")
    public List<Categorie> categorieList() {
        return categorieService.categorieList();
    }
}
