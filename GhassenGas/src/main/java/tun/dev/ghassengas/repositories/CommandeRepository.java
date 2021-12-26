package tun.dev.ghassengas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.Commande;
import tun.dev.ghassengas.entities.Produit;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    @Query(value = "SELECT * FROM `produit` as p JOIN `ligne_commande` as j ON `j`.`produit_id`=p.`id_produit` WHERE j.`commande_id`=:commandeId", nativeQuery = true)
    List<Produit> listeProduitsDansCommande(Integer commandeId);
}
