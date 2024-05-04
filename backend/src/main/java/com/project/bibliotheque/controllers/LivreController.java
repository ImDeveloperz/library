package com.project.bibliotheque.controllers;


import com.project.bibliotheque.entities.Livre;
import com.project.bibliotheque.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {
    private final LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public List<Livre> getAllLivres(){
        return livreService.getAllLivres();
    }
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id){
        return livreService.getLivreById(id);
    }
    @PostMapping
    public Livre addLivre(@RequestBody Livre livre){
        return livreService.addLivre(livre);
    }
    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable Long id,@RequestBody Livre livre){
        livre.setIdDocument(id);
        return livreService.updateLivre(livre);
    }
    @DeleteMapping("/{id}")
    public void deleteLivreById(@PathVariable Long id){
        livreService.deleteLivreById(id);
    }
}
