package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.LivreDto;
import com.project.bibliotheque.entities.Livre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivreMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    LivreDto toDto(Livre livre);
    Livre toEntity(LivreDto livreDto);
}