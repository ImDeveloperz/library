package com.project.bibliotheque.controllers;

import com.project.bibliotheque.entities.Journale;
import com.project.bibliotheque.services.JournaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journales")
public class JournaleController {
    private final JournaleService journaleService;

    public JournaleController(JournaleService journaleService) {
        this.journaleService = journaleService;
    }
    @GetMapping
    public List<Journale> getAllJournales(){
        return journaleService.getAllJournales();
    }
    @GetMapping("/{id}")
    public Journale getJournaleById(@PathVariable Long id){
        return journaleService.getJournaleById(id);
    }
    @PostMapping
    public Journale addJournale(@RequestBody Journale journale){
        return journaleService.addJournale(journale);
    }
    @PutMapping("/{id}")
    public Journale updateJournale(@PathVariable Long id,@RequestBody Journale journale){
        journale.setIdDocument(id);
        return journaleService.updateJournale(journale);
    }
    @DeleteMapping("/{id}")
    public void deleteJournaleById(@PathVariable Long id){
        journaleService.deleteJournaleById(id);
    }
}
