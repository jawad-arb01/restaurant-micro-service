package com.arbahi.clientservice.feignClient;

import com.arbahi.clientservice.entities.Repas;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "repas-service", url = "${repas.service.url}")
public interface RepasFeignClient {
    @GetMapping("/{id}")
    Repas getRepasById(@PathVariable("id") Long id);

    @GetMapping
    List<Repas> getALlRepas();
}
