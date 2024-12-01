package com.arbahi.repasservice.services;

import com.arbahi.repasservice.entities.Repas;
import com.arbahi.repasservice.repositories.RepasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepasService {
    private final RepasRepository repasRepository;

    public Repas saveRepas(Repas repas) {
        return repasRepository.save(repas);
    }

    public Repas getRepasById(Long id) {
        return repasRepository.findById(id).orElseThrow(() -> new RuntimeException("Repas not found"));
    }

    public void deleteRepas(Long id) {
        repasRepository.deleteById(id);
    }
}
