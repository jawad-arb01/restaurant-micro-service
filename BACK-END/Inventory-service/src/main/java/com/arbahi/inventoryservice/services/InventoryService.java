package com.arbahi.inventoryservice.services;

import com.arbahi.inventoryservice.entities.Inventory;
import com.arbahi.inventoryservice.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getItemById(String id) {
        return inventoryRepository.findById(id);
    }

    public Inventory createItem(Inventory inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }

    public Inventory updateItem(String id, Inventory inventoryItem) {
        inventoryItem.setId(id);
        return inventoryRepository.save(inventoryItem);
    }

    public void deleteItem(String id) {
        inventoryRepository.deleteById(id);
    }

    public void decreaseQuantities(Map<String, Integer> ingredients) {
        for (Map.Entry<String, Integer> ingredient : ingredients.entrySet()) {
            String ingredientName = ingredient.getKey();
            Integer quantityToReduce = ingredient.getValue();
            Inventory inventoryItem = inventoryRepository.findByName(ingredientName)
                    .orElseThrow(() -> new RuntimeException("Ingredient not found: " + ingredientName));

            if (inventoryItem.getQuantity() < quantityToReduce) {
                throw new RuntimeException("Insufficient quantity for ingredient: " + ingredientName);
            }
            inventoryItem.setQuantity(inventoryItem.getQuantity() - quantityToReduce);
            inventoryRepository.save(inventoryItem);
        }
    }
}
