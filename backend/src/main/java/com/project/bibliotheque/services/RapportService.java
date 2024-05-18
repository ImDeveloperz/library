package com.project.bibliotheque.services;

import com.project.bibliotheque.dtos.RapportDto;
import com.project.bibliotheque.entities.Document;
import com.project.bibliotheque.entities.Rapport;
import com.project.bibliotheque.mappers.RapportMapper;
import com.project.bibliotheque.repositories.DocumentRepository;
import com.project.bibliotheque.repositories.RapportRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RapportService {
    private final RapportMapper rapportMapper;
    private final DocumentRepository documentRepository;
    private final RapportRepository rapportRepository;

    public RapportService(DocumentRepository documentRepository, RapportRepository rapportRepository, RapportMapper rapportMapper) {
        this.documentRepository = documentRepository;
        this.rapportRepository = rapportRepository;
        this.rapportMapper = rapportMapper;
    }
    //add a new rapport
    public Rapport addRapport(Rapport rapport){
        return rapportRepository.save(rapport);
    }
    //update a rapport
    public Rapport updateRapport(Rapport rapport){
        return rapportRepository.save(rapport);
    }
    //get a rapport by id
    public RapportDto getRapportById(Long id){
        return rapportMapper.toDto(rapportRepository.findById(id).orElse(null));
    }

}