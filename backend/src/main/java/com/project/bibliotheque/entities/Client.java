package com.project.bibliotheque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@DiscriminatorValue("Client")

public class Client extends Utilisateur {
     private Long montantTotal= 0L;
     @Override
     public String toString() {
          if (this.getCarteClient() != null) {
               return STR."""
                      addresse= \{this.getAddresse()}
                      idCart= \{this.getCarteClient().getIdCarteClient()}
                      idClient = \{this.getId()}
                      nom= \{this.getNom()}
                      prenom= \{this.getPrenom()}
                      estRegistered=\{this.isEstRegistered()} """;
          }else{
               return STR."""
                     addresse= \{this.getAddresse()}
                     idClient = \\{this.getId()}
                     nom= \{this.getNom()}
                      prenom= \{this.getPrenom()}
                     estRegistered=\{this.isEstRegistered()} """;
          }
     }
}
