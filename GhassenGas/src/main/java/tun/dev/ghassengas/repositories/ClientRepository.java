package tun.dev.ghassengas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tun.dev.ghassengas.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
