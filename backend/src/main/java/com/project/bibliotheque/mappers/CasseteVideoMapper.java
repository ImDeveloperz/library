package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.CasseteVideoDto;
import com.project.bibliotheque.entities.CasseteVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CasseteVideoMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    CasseteVideoDto toDto(CasseteVideo casseteVideo);
    CasseteVideo toEntity(CasseteVideoDto casseteVideoDto);
}