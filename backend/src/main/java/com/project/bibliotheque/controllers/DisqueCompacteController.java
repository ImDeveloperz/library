package com.project.bibliotheque.controllers;


import com.project.bibliotheque.entities.DisqueCompacte;
import com.project.bibliotheque.services.DisqueCompacteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disquescompacts")
public class DisqueCompacteController {
    private final DisqueCompacteService disqueCompacteService;

    public DisqueCompacteController(DisqueCompacteService disqueCompacteService) {
        this.disqueCompacteService = disqueCompacteService;
    }
    @GetMapping
    public List<DisqueCompacte> getAllDisqueCompacts(){
        return disqueCompacteService.getAllDisqueCompactes();
    }
    @GetMapping("/{id}")
    public DisqueCompacte getDisqueCompacteById(Long id){
        return disqueCompacteService.getDisqueCompacteById(id);
    }
    @PostMapping
    public DisqueCompacte addDisqueCompacte(DisqueCompacte disqueCompacte){
        return disqueCompacteService.addDisqueCompacte(disqueCompacte);
    }
    @PutMapping("/{id}")
    public DisqueCompacte updateDisqueCompacte(Long id, DisqueCompacte disqueCompacte){
        disqueCompacte.setIdDocument(id);
        return disqueCompacteService.updateDisqueCompacte(disqueCompacte);
    }
    @DeleteMapping("/{id}")
    public void deleteDisqueCompacteById(Long id){
        disqueCompacteService.deleteDisqueCompacteById(id);
    }


}
