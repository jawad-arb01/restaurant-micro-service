package com.arbahi.clientservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repas {
    private Long id;
    private String name;
    private List<String> ingredients;
}
