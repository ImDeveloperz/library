package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.RapportDto;
import com.project.bibliotheque.entities.Rapport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RapportMapper {
    RapportDto toDto(Rapport rapport);
    Rapport toEntity(RapportDto rapportDto);
}