package tun.dev.ghassengas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	@Query(value = "SELECT * FROM produit JOIN ligne_commande ON ligne_commande.produit_id=produit.id_produit WHERE commande_id=:commandeId", nativeQuery = true)
     List<Produit> listeProduitsDansCommande(@Param("commandeId") int commandeId);
	
}
