package com.project.bibliotheque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Journale")
public class Journale extends Document{
    private Integer edition;
}
