package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.DisqueCompacteDto;
import com.project.bibliotheque.entities.DisqueCompacte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DisqueCompacteMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    DisqueCompacteDto toDto(DisqueCompacte disqueCompacte);
    DisqueCompacte toEntity(DisqueCompacteDto disqueCompacteDto);
}