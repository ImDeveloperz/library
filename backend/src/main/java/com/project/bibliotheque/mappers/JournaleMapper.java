package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.JournaleDto;
import com.project.bibliotheque.entities.Journale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JournaleMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    JournaleDto toDto(Journale journale);
    Journale toEntity(JournaleDto journaleDto);
}