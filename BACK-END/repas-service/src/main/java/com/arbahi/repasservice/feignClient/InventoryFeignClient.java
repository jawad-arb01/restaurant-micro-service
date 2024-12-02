package com.arbahi.repasservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "inventory-service" , url = "http://localhost:9092/api/v1/inventory")
public interface InventoryFeignClient {
    @PutMapping("/decrease-ingredients")
    void decreaseIngredientQuantities(@RequestBody Map<String, Integer> ingredients);
}
