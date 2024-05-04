package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.BibliothecaireDto;
import com.project.bibliotheque.entities.Bibliothecaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BibliothecaireMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "bibliotheque.id", target = "idBibliotheque")
    BibliothecaireDto toDto(Bibliothecaire bibliothecaire);
    Bibliothecaire toEntity(BibliothecaireDto bibliothecaireDto);
}