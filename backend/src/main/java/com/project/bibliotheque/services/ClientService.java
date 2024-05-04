package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Client;
import com.project.bibliotheque.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    //service
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client addClient(Client client){
        return  clientRepository.save(client);
    }

    public Client updateClient(Client client){
        //update client
        return clientRepository.save(client);
    }
    public Client getClientById(Long id){
        //get client
        return clientRepository.findById(id).orElse(null);
    }
    public List<Client> getAllClients(){
        //get all clients
        return clientRepository.findAll();
    }
    public void deleteClientById(Long id){
        //delete client
        clientRepository.deleteById(id);
    }
}
