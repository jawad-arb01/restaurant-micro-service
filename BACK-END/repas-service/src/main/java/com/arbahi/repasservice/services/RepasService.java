package com.arbahi.repasservice.services;

import com.arbahi.repasservice.entities.Repas;
import com.arbahi.repasservice.exceptions.RepasNotFoundException;
import com.arbahi.repasservice.feignClient.InventoryFeignClient;
import com.arbahi.repasservice.repositories.RepasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RepasService {

    private final RepasRepository repasRepository;
    private final InventoryFeignClient inventoryFeignClient;

    public Repas saveRepas(Repas repas) {
        Map<String, Integer> ingredientsMap = repas.getIngredients();
        inventoryFeignClient.decreaseIngredientQuantities(ingredientsMap);
        return repasRepository.save(repas);
    }

    public Repas getRepasById(Long id) {
        return repasRepository.findById(id).orElseThrow(() -> new RepasNotFoundException("Repas not found"));
    }

    public List<Repas> getAllRepas() {
        return repasRepository.findAll();
    }

    public void deleteRepas(Long id) {
        repasRepository.deleteById(id);
    }
}
