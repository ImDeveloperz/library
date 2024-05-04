package com.project.bibliotheque.controllers;


import com.project.bibliotheque.dtos.UtilisateurDto;
import com.project.bibliotheque.entities.Utilisateur;
import com.project.bibliotheque.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UtilisateurController {
    UtilisateurService utilisateurService;
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @GetMapping("/all")
    public List<UtilisateurDto> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }
    @GetMapping("/user")
    public ResponseEntity<Map<String,UtilisateurDto>> getUtilisateurByEmail(@RequestParam String email){
        try{
            UtilisateurDto utilisateur = utilisateurService.getUtilisateurByEmail(email);
            return ResponseEntity.ok().body(Map.of("utilisateur",utilisateur));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("Utilisateur non trouve",null));
        }
    }
}
