package com.arbahi.repasservice.controllers;

import com.arbahi.repasservice.entities.Repas;
import com.arbahi.repasservice.services.RepasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/repas")
@RequiredArgsConstructor
public class RepasController {
    private final RepasService repasService;

    @PostMapping
    public Repas createRepas(@RequestBody Repas repas) {
        return repasService.saveRepas(repas);
    }

    @GetMapping("/{id}")
    public Repas getRepasById(@PathVariable Long id) {
        return repasService.getRepasById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRepas(@PathVariable Long id) {
        repasService.deleteRepas(id);
        return "Repas deleted successfully!";
    }
}
