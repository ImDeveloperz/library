package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Journale;
import com.project.bibliotheque.repositories.JournaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournaleService {
    private final JournaleRepository journaleRepository;


    public JournaleService(JournaleRepository journaleRepository) {
        this.journaleRepository = journaleRepository;
    }
    public Journale addJournale(Journale journale){
        return journaleRepository.save(journale);
    }
    public Journale updateJournale(Journale journale){
        return journaleRepository.save(journale);
    }
    public Journale getJournaleById(Long id){
        return journaleRepository.findById(id).orElse(null);
    }
    public List<Journale> getAllJournales(){
        return journaleRepository.findAll();
    }
    public void deleteJournaleById(Long id){
        journaleRepository.deleteById(id);
    }

}

