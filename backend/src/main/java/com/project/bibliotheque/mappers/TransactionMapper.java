package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.TransactionDto;
import com.project.bibliotheque.entities.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto toDto(Transaction transaction);
    Transaction toEntity(TransactionDto transactionDto);
}