package com.project.bibliotheque.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapportDto {
    private Long id;
    private String titre;
    private String description;
    private String dateCreation;
    private int nombrePret;
    private int nombreRetard;
    private int nombreReservation;
    private Long documentId;
}
