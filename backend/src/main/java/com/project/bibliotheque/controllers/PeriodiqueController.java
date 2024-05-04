package com.project.bibliotheque.controllers;

import com.project.bibliotheque.entities.Periodique;
import com.project.bibliotheque.services.PeriodiqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodiques")
public class PeriodiqueController {
    private final PeriodiqueService periodiqueService;

    public PeriodiqueController(PeriodiqueService periodiqueService) {
        this.periodiqueService = periodiqueService;
    }
    @GetMapping
    public List<Periodique> getAllPeriodiques(){
        return periodiqueService.getAllPeriodiques();
    }
    @GetMapping("/{id}")
    public Periodique getPeriodiqueById(@PathVariable Long id){
        return periodiqueService.getPeriodiqueById(id);
    }
    @PostMapping
    public Periodique addPeriodique(@RequestBody Periodique periodique){
        return periodiqueService.addPeriodique(periodique);
    }
    @PutMapping("/{id}")
    public Periodique updatePeriodique(@PathVariable Long id, @RequestBody Periodique periodique){
        periodique.setIdDocument(id);
        return periodiqueService.updatePeriodique(periodique);
    }
    @DeleteMapping("/{id}")
    public void deletePeriodiqueById(@PathVariable Long id){
        periodiqueService.deletePeriodiqueById(id);
    }
}
