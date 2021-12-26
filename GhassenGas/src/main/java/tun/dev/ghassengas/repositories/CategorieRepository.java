package tun.dev.ghassengas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
