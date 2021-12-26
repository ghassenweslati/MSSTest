package tun.dev.ghassengas.controllers;

import org.springframework.web.bind.annotation.*;
import tun.dev.ghassengas.entities.Client;
import tun.dev.ghassengas.services.ClientService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Ajouter un client
    @PostMapping("/ajoutClient")
    public void ajoutClient(@RequestBody Client client) {
        clientService.ajoutClient(client);
    }

    //Afficher liste des clients
    @GetMapping("/listClients")
    public List<Client> ListClients() {
        return clientService.clientList();
    }

    //supprimer client par Id
    @DeleteMapping("/deleteClient/{clientId}")
    public void deleteClient(@PathVariable int clientId) {
        clientService.deleteClient(clientId);
    }
}
