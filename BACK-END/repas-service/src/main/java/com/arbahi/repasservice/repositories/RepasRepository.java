package com.arbahi.repasservice.repositories;

import com.arbahi.repasservice.entities.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepasRepository extends JpaRepository<Repas, Long> {
}
