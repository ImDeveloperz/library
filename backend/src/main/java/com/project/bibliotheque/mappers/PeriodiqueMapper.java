package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.PeriodiqueDto;
import com.project.bibliotheque.entities.Periodique;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PeriodiqueMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    PeriodiqueDto toDto(Periodique periodique);
    Periodique toEntity(PeriodiqueDto periodiqueDto);
}