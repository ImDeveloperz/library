package com.project.bibliotheque.controllers;

import com.project.bibliotheque.dtos.DocumentDto;
import com.project.bibliotheque.services.DocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @GetMapping("/{id}")
    public DocumentDto getDocumentById(@PathVariable Long id){
        return documentService.getDocumentById(id);
    }

    @GetMapping
    public Page<DocumentDto> getAllDocuments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size,@RequestParam(defaultValue = "") String search){
        return documentService.getAllDocuments(page,size,search);
    }
    @GetMapping("/search")
    public Page<DocumentDto> getDocumentsByTitreContaining(@RequestParam String titre, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size){
        Pageable pageable = PageRequest.of(page, size);
        return documentService.getDocumentsByTitreContaining(titre, pageable);
    }
    @PostMapping
    public DocumentDto addDocument(@RequestBody DocumentDto documentDto){
        return documentService.addDocument(documentDto);
    }
    @PutMapping("/{id}")
    public DocumentDto updateDocument(@PathVariable Long id, @RequestBody DocumentDto documentDto){
        documentDto.setIdDocument(id);
        return documentService.updateDocument(documentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteDocumentById(@PathVariable Long id){
        documentService.deleteDocumentById(id);
    }
}