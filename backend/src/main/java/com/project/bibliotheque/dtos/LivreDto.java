package com.project.bibliotheque.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivreDto extends DocumentDto {
    private int nbPage;
    private int classification;
}
