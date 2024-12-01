package com.arbahi.inventoryservice.services;

import com.arbahi.inventoryservice.entities.Inventory;
import com.arbahi.inventoryservice.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory createItem(Inventory inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }

    public Inventory updateItem(Long id, Inventory inventoryItem) {
        inventoryItem.setId(id);
        return inventoryRepository.save(inventoryItem);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}
