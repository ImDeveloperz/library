package com.project.bibliotheque.mappers;

import com.project.bibliotheque.dtos.DocumentDto;
import com.project.bibliotheque.entities.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "bibliotheque.id", target = "bibliothequeId")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(source = "rapports", target = "rapports")
    @Mapping(source = "discripteurs", target = "discripteurs")
    @Mapping(expression = "java(document.getClass().getSimpleName())", target = "type")
    DocumentDto toDto(Document document);
    Document toEntity(DocumentDto documentDto);

}