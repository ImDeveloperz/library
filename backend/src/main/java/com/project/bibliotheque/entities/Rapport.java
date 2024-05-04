package com.project.bibliotheque.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private Long idRapport;
    private String statistique;
    private Date dateStatistique;
    private String typeStatistique;
    private int nombrePret;
    private int nombreRetard;
    private int nombreReservation;
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
