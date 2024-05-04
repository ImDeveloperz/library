package com.project.bibliotheque.services;

import com.project.bibliotheque.entities.Livre;
import com.project.bibliotheque.repositories.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    private final LivreRepository livreRepository;


    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }
    public Livre addLivre(Livre livre){
        return livreRepository.save(livre);
    }
    public Livre updateLivre(Livre livre){
        return livreRepository.save(livre);
    }
    public Livre getLivreById(Long id){
        return livreRepository.findById(id).orElse(null);
    }
    public List<Livre> getAllLivres(){
        return livreRepository.findAll();
    }
    public void deleteLivreById(Long id){
        livreRepository.deleteById(id);
    }
}
