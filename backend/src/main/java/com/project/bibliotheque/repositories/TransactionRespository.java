package com.project.bibliotheque.repositories;

import com.project.bibliotheque.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRespository extends JpaRepository<Transaction, Long> {
}
