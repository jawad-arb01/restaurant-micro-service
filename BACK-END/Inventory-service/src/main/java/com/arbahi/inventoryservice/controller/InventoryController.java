package com.arbahi.inventoryservice.controller;

import com.arbahi.inventoryservice.entities.Inventory;
import com.arbahi.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllItems() {
        List<Inventory> items = inventoryService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getItemById(@PathVariable String id) {
        Optional<Inventory> item = inventoryService.getItemById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> createItem(@RequestBody Inventory inventoryItem) {
        Inventory savedItem = inventoryService.createItem(inventoryItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateItem(@PathVariable String id, @RequestBody Inventory inventoryItem) {
        Inventory updatedItem = inventoryService.updateItem(id, inventoryItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decrease-ingredients")
    public void decreaseIngredientQuantities(@RequestBody Map<String, Integer> ingredients) {
        inventoryService.decreaseQuantities(ingredients);
    }
}
