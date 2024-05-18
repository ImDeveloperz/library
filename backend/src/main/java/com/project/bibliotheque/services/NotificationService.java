package com.project.bibliotheque.services;

import com.project.bibliotheque.dtos.ClientDto;
import com.project.bibliotheque.dtos.DocumentDto;
import com.project.bibliotheque.dtos.NotificationDto;
import com.project.bibliotheque.entities.Notification;
import com.project.bibliotheque.mappers.BibliothecaireMapper;
import com.project.bibliotheque.mappers.ClientMapper;
import com.project.bibliotheque.mappers.DocumentMapper;
import com.project.bibliotheque.mappers.NotificationMapper;
import com.project.bibliotheque.repositories.NotificationRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final DocumentService documentService;
    private final DocumentMapper documentMapper;
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final BibliothecaireService bibliothecaireService;
    private final BibliothecaireMapper bibliothecaireMapper;
    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper, DocumentService documentService, ClientService clientService, BibliothecaireService bibliothecaireService, DocumentMapper documentMapper, ClientMapper clientMapper, BibliothecaireMapper bibliothecaireMapper){
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.documentService = documentService;
        this.clientService = clientService;
        this.bibliothecaireService = bibliothecaireService;
        this.documentMapper = documentMapper;
        this.clientMapper = clientMapper;
        this.bibliothecaireMapper = bibliothecaireMapper;
    }

    public NotificationDto addNotification(NotificationDto notificationDto){
        Notification notification = notificationMapper.toEntity(notificationDto);
        return notificationMapper.toDto(notificationRepository.save(notification));
    }
    public List<NotificationDto> getNotificationsByRecepteurId(Long recepteurId){
        List<Notification> notifications = notificationRepository.findByRecepteurId(recepteurId);
        return notifications.stream().map(notificationMapper::toDto).collect(Collectors.toList());
    }
    public NotificationDto updateNotification(NotificationDto notificationDto){
        Notification notification = notificationMapper.toEntity(notificationDto);
        return notificationMapper.toDto(notificationRepository.save(notification));
    }
    public NotificationDto getNotificationById(Long id){
        Notification notification = notificationRepository.findById(id).orElse(null);
        return notificationMapper.toDto(notification);
    }
    public List<NotificationDto> getAllNotifications(){
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream().map(notificationMapper::toDto).collect(Collectors.toList());
    }
    public void deleteNotificationById(Long id){
        notificationRepository.deleteById(id);
    }

    public Notification sendNotificationFromLocation(String message, Long recepteurId, String emetteurEmail, LocalDate dateDebut, LocalDate dateFin, Long documentId) {
        Notification notification = new Notification();
        notification.setMessage(message);
        DocumentDto documentDto = documentService.getDocumentById(documentId);
        notification.setRecepteur(clientMapper.toEntity(clientService.getClientById(recepteurId)));
        notification.setEmeteur(bibliothecaireMapper.toEntity(bibliothecaireService.getBibliothecaireByEmail(emetteurEmail)));
        if(dateFin.isBefore(LocalDate.now())){
            Long montant = 0L;
            Long nbJourRetard = (ChronoUnit.DAYS.between(dateFin, LocalDate.now()));
            Long nbJour = (ChronoUnit.DAYS.between(dateDebut, LocalDate.now()));
            montant = (documentDto.getFraixExige() * nbJour ) + (10 * nbJourRetard);
            notification.setMontant(montant);
            ClientDto clientDto = clientService.getClientById(recepteurId);
            clientDto.setMontantTotal(clientDto.getMontantTotal() + montant);
            clientService.updateClient(clientDto);
        }else{
            ClientDto clientDto = clientService.getClientById(recepteurId);
            Long nbJour = (ChronoUnit.DAYS.between(dateDebut, LocalDate.now()));
            Long montant = documentDto.getFraixExige() * nbJour;
            notification.setMontant(montant);
            clientDto.setMontantTotal(clientDto.getMontantTotal() + montant);
            clientService.updateClient(clientDto);
        }
        return notificationRepository.save(notification);
    }

    public Notification sendNotificationFromPretation(String message, Long recepteurId, String emetteurEmail, LocalDate dateDebut, LocalDate dateFin, Long documentId) {
        Notification notification = new Notification();
        notification.setMessage(message);
        DocumentDto documentDto = documentService.getDocumentById(documentId);
        ClientDto clientDto = clientService.getClientById(recepteurId);
        notification.setRecepteur(clientMapper.toEntity(clientDto));
        Long montant = 0L;
        notification.setEmeteur(bibliothecaireMapper.toEntity(bibliothecaireService.getBibliothecaireByEmail(emetteurEmail)));
        if(dateFin.isBefore(LocalDate.now())){
            Long nbJourRetard = (ChronoUnit.DAYS.between(dateFin, LocalDate.now()));
            montant = (5 * nbJourRetard);
        }
        notification.setMontant(montant);
        clientDto.setMontantTotal(clientDto.getMontantTotal() + montant);
        clientService.updateClient(clientDto);
        return notificationRepository.save(notification);
    }
}
