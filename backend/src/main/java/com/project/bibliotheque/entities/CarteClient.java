package com.project.bibliotheque.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarteClient {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idCarteClient;
    @Column(nullable = false)
    private String code;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @OneToOne
    private Client client;
}
