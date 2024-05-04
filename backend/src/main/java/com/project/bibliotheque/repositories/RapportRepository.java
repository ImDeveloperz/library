package com.project.bibliotheque.repositories;

import com.project.bibliotheque.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport, Long> {
}
