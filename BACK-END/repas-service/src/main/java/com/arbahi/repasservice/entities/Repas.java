package com.arbahi.repasservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "repas")
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ElementCollection
    @Column(nullable = false)
    private Map<String,Integer> ingredients;
}
