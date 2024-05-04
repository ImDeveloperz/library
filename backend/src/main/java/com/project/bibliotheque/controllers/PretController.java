package com.project.bibliotheque.controllers;


import com.project.bibliotheque.entities.Pret;
import com.project.bibliotheque.services.PretService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prets")
public class PretController {
    private final PretService pretService;

    public PretController(PretService pretService) {
        this.pretService = pretService;
    }
    @GetMapping
    public List<Pret> getAllPrets(){
        return pretService.getAllPrets();
    }
    @GetMapping("/{id}")
    public Pret getPretById(Long id){
        return pretService.getPretById(id);
    }
    @PostMapping
    public Pret addPret(Pret pret){
        return pretService.addPret(pret);
    }
    @PutMapping("/{id}")
    public Pret updatePret(Long id, Pret pret){
        pret.setIdTransaction(id);
        return pretService.updatePret(pret);
    }
    @DeleteMapping("/{id}")
    public void deletePretById(Long id){
        pretService.deletePretById(id);
    }
}
