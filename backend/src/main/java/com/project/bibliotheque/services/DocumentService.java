package com.project.bibliotheque.services;

import com.project.bibliotheque.dtos.DocumentDto;
import com.project.bibliotheque.entities.Document;
import com.project.bibliotheque.mappers.DocumentMapper;
import com.project.bibliotheque.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, DocumentMapper documentMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }

    public DocumentDto addDocument(DocumentDto documentDto){
        Document document = documentMapper.toEntity(documentDto);
        document = documentRepository.save(document);
        return documentMapper.toDto(document);
    }

    public DocumentDto updateDocument(DocumentDto documentDto){
        Document document = documentMapper.toEntity(documentDto);
        document = documentRepository.save(document);
        return documentMapper.toDto(document);
    }

    public DocumentDto getDocumentById(Long id){
        Document document = documentRepository.findById(id).orElse(null);
        return documentMapper.toDto(document);
    }

    public Page<DocumentDto> getAllDocuments(int page,int size,String search){
        List<Document> allDocuments = documentRepository.findAll().stream()
                .filter(document -> document.getTitre().toLowerCase().contains(search.toLowerCase())
                        || document.getDiscripteurs().stream().anyMatch(discripteur -> discripteur.getKeyword().toLowerCase().contains(search.toLowerCase())))
                .collect(Collectors.toList());

        // Calculate the start and end item indices for the desired page
        int start = Math.min((page * size), allDocuments.size());
        int end = Math.min(start + size, allDocuments.size());

        // Extract the specific page from the filtered list
        List<DocumentDto> documentPage = allDocuments.subList(start, end).stream()
                .map(documentMapper::toDto)
                .collect(Collectors.toList());

        // Return the page as a Page object
        return new PageImpl<>(documentPage, PageRequest.of(page, size), allDocuments.size());
    }
    public Page<DocumentDto> getDocumentsByTitreContaining(String titre, Pageable pageable){
        Page<Document> documents = documentRepository.findByTitreContaining(titre, pageable);

        return documents.map(documentMapper::toDto);
    }

    public void deleteDocumentById(Long id){
        documentRepository.deleteById(id);
    }
}