package com.project.bibliotheque.controllers;

import com.project.bibliotheque.dtos.BibliothecaireDto;
import com.project.bibliotheque.services.BibliothecaireService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliothecaire")
public class BibliothecaireController{
    private final BibliothecaireService bibliothecaireService;

    public BibliothecaireController(BibliothecaireService bibliothecaireService) {
        this.bibliothecaireService = bibliothecaireService;
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping
    public List<BibliothecaireDto> getAllBibliothecaire(){
        return bibliothecaireService.getAllBibliothecaires();
    }

    @PreAuthorize("hasRole('bibliothequaire') or hasRole('admin')")
    @GetMapping("/{id}")
    public BibliothecaireDto getBibliothecaireById(@PathVariable Long id){
        return bibliothecaireService.getBibliothecaireById(id);
    }
    @PreAuthorize("hasRole('bibliothequaire') or hasRole('admin')")
    @PostMapping
    public BibliothecaireDto addBibliothecaire(@RequestBody BibliothecaireDto bibliothecaireDto){
        return bibliothecaireService.addBibliothecaire(bibliothecaireDto);
    }
    @PreAuthorize("hasRole('bibliothequaire') or hasRole('admin')")
    @PutMapping("/{id}")
    public BibliothecaireDto updateBibliothecaire(@PathVariable Long id, @RequestBody BibliothecaireDto bibliothecaireDto){
        bibliothecaireDto.setId(id);
        return bibliothecaireService.updateBibliothecaire(bibliothecaireDto);
    }
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public void deleteBibliothecaireById(@PathVariable Long id){
        bibliothecaireService.deleteBibliothecaireById(id);
    }
}