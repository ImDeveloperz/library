package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Periodique;
import com.project.bibliotheque.repositories.PeriodiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodiqueService {
    private PeriodiqueRepository periodiqueRepository;

    @Autowired
    public PeriodiqueService(PeriodiqueRepository periodiqueRepository) {
        this.periodiqueRepository = periodiqueRepository;
    }
    public Periodique addPeriodique(Periodique periodique){
        return periodiqueRepository.save(periodique);
    }
    public Periodique updatePeriodique(Periodique periodique){
        return periodiqueRepository.save(periodique);
    }
    public Periodique getPeriodiqueById(Long id){
        return periodiqueRepository.findById(id).orElse(null);
    }
    public List<Periodique> getAllPeriodiques(){
        return periodiqueRepository.findAll();
    }
    public void deletePeriodiqueById(Long id){
        periodiqueRepository.deleteById(id);
    }
}
