package com.project.bibliotheque.services;

import com.project.bibliotheque.dtos.UtilisateurDto;
import com.project.bibliotheque.entities.Utilisateur;
import com.project.bibliotheque.mappers.UtilisateurMapper;
import com.project.bibliotheque.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    UtilisateurRepository utilisateurRepository;
    UtilisateurMapper utilisateurMapper;
    public UtilisateurService(UtilisateurRepository utilisateurReposititory,UtilisateurMapper utilisateurMapper){
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurRepository = utilisateurReposititory;
    }
    public UtilisateurDto addUtilisateur(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        return  utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }
    public UtilisateurDto getUtilisateurById(Long id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return utilisateurMapper.toDto(utilisateur);
    }
    public UtilisateurDto getUtilisateurByEmail(String email){
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        return utilisateurMapper.toDto(utilisateur);
    }
    public UtilisateurDto getUtilisateurByNom(String nom){
        Utilisateur utilisateur = utilisateurRepository.findByNom(nom);
        return utilisateurMapper.toDto(utilisateur);
    }
    public UtilisateurDto  updateUtilisateur(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        return utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }
    public void deleteUtilisateurById(Long id){
        utilisateurRepository.deleteById(id);
    }
    public List<UtilisateurDto> getAllUtilisateurs(){
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateurMapper::toDto).collect(Collectors.toList());
    }
}
