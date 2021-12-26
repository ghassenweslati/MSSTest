package tun.dev.ghassengas.services;

import org.springframework.stereotype.Service;
import tun.dev.ghassengas.entities.Client;
import tun.dev.ghassengas.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void ajoutClient(Client client) {
        clientRepository.save(client);

    }

    public List<Client> clientList() {
        return clientRepository.findAll();

    }

    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
