package com.arbahi.inventoryservice.repositories;

import com.arbahi.inventoryservice.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {
    Optional<Inventory> findByName(String name);
}
