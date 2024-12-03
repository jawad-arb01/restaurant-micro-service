package com.arbahi.clientservice.dtos;

import com.arbahi.clientservice.entities.Client;
import com.arbahi.clientservice.entities.Repas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRepasDTO {
    private Client client;
    private Repas repas;
}
