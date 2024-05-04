package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.DisqueCompacte;
import com.project.bibliotheque.repositories.DisqueCompacteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisqueCompacteService {
    private final DisqueCompacteRepository disqueCompacteRepository;

    @Autowired
    public DisqueCompacteService(DisqueCompacteRepository disqueCompacteRepository) {
        this.disqueCompacteRepository = disqueCompacteRepository;
    }
    public DisqueCompacte addDisqueCompacte(DisqueCompacte disqueCompacte){
        return disqueCompacteRepository.save(disqueCompacte);
    }
    public DisqueCompacte updateDisqueCompacte(DisqueCompacte disqueCompacte){
        return disqueCompacteRepository.save(disqueCompacte);
    }
    public DisqueCompacte getDisqueCompacteById(Long id){
        return disqueCompacteRepository.findById(id).orElse(null);
    }
    public List<DisqueCompacte> getAllDisqueCompactes(){
        return disqueCompacteRepository.findAll();
    }
    public void deleteDisqueCompacteById(Long id){
        disqueCompacteRepository.deleteById(id);
    }
}
