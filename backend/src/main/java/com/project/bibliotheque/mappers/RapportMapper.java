package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.RapportDto;
import com.project.bibliotheque.entities.Rapport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RapportMapper {
    @Mapping(source = "document.idDocument", target = "documentId")
    RapportDto toDto(Rapport rapport);
    Rapport toEntity(RapportDto rapportDto);
}