package com.arbahi.clientservice.controllers;

import com.arbahi.clientservice.dtos.ClientRepasDTO;
import com.arbahi.clientservice.entities.Client;
import com.arbahi.clientservice.entities.Repas;
import com.arbahi.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/getall")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @GetMapping("/{clientId}/order/{repasId}")
    public ClientRepasDTO getClientAndMealDetails(@PathVariable Long clientId, @PathVariable Long repasId) {
        return clientService.getClientAndMealDetails(clientId, repasId);
    }

    @GetMapping("/getAllRepas")
    public List<Repas> getAllMeals() {
        return clientService.getAllMeals();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
