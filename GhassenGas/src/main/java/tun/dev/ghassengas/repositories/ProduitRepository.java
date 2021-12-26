package tun.dev.ghassengas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    @Query(value = "SELECT * FROM produit WHERE categorie_id=:categorieId", nativeQuery = true)
    List<Produit> findAllByCategorie(int categorieId);
}
