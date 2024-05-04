package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Pret;
import com.project.bibliotheque.repositories.PretRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PretService {
    private final PretRepository pretRepository;

    public PretService(PretRepository pretRepository) {
        this.pretRepository = pretRepository;
    }
    public Pret addPret(Pret pret){
        return pretRepository.save(pret);
    }
    public Pret updatePret(Pret pret){
        return pretRepository.save(pret);
    }
    public Pret getPretById(Long id){
        return pretRepository.findById(id).orElse(null);
    }
    public List<Pret> getAllPrets(){
        return pretRepository.findAll();
    }
    public void deletePretById(Long id){
        pretRepository.deleteById(id);
    }
}
