package com.project.bibliotheque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("Client")

public class Client extends Utilisateur {
     private String addresse;
     @OneToOne(mappedBy = "client")
     private CarteClient carteClient;
}
