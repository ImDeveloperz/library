package com.project.bibliotheque.controllers;


import com.project.bibliotheque.entities.Client;
import com.project.bibliotheque.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public Client getClientById(Long id){
        return clientService.getClientById(id);
    }
    @PostMapping
    public Client addClient(Client client){
        return clientService.addClient(client);
    }
    @PutMapping("/{id}")
    public Client updateClient(Long id, Client client){
        client.setId(id);
        return clientService.updateClient(client);
    }
    @DeleteMapping("/{id}")
    public void deleteClientById(Long id){
        clientService.deleteClientById(id);
    }
}
