package tun.dev.ghassengas.repositories;

import org.hibernate.annotations.OnDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.LigneCommande;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

    @Query(value = "SELECT * FROM ligne_commande WHERE commande_id=:commandeId", nativeQuery = true)
    List<LigneCommande> findByCommandeId(int commandeId);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ligne_commande WHERE produit_id=:produitId AND commande_id=:commandeId", nativeQuery = true)
    void deleteProduitFromLigneCommande(int produitId, int commandeId);
}
