package com.arbahi.clientservice.services;

import com.arbahi.clientservice.dtos.ClientRepasDTO;
import com.arbahi.clientservice.entities.Client;
import com.arbahi.clientservice.entities.Repas;
import com.arbahi.clientservice.feignClient.RepasFeignClient;
import com.arbahi.clientservice.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final RepasFeignClient repasFeignClient;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = getClientById(id);
        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhone(updatedClient.getPhone());
        existingClient.setAddress(updatedClient.getAddress());
        return clientRepository.save(existingClient);
    }

    public ClientRepasDTO getClientAndMealDetails(Long clientId, Long repasId) {
        Client client = getClientById(clientId);
        Repas repas = repasFeignClient.getRepasById(repasId);
        return new ClientRepasDTO(client, repas);
    }

    public List<Repas> getAllMeals() {
        return repasFeignClient.getALlRepas();
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
