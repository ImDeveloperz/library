package com.project.bibliotheque.controllers;

import com.project.bibliotheque.dtos.NotificationDto;
import com.project.bibliotheque.entities.Notification;
import com.project.bibliotheque.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("/all")
    public List<NotificationDto> getAllNotifications(){
        return notificationService.getAllNotifications();
    }
    @GetMapping
    public ResponseEntity<List<NotificationDto>> getNotificationsByUserId(@RequestParam Long recepteurId){
        try{
            List<NotificationDto> notifications = notificationService.getNotificationsByRecepteurId(recepteurId);
            return ResponseEntity.ok().body(notifications);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/{id}")
    public NotificationDto getNotificationById(Long id){
        return notificationService.getNotificationById(id);
    }
    @PostMapping
    public NotificationDto addNotification(NotificationDto notificationDto){
        return notificationService.addNotification(notificationDto);
    }
    @PutMapping("/{id}")
    public NotificationDto updateNotification(Long id, NotificationDto notificationDto){
        notificationDto.setId(id);
        return notificationService.updateNotification(notificationDto);
    }
    @DeleteMapping("/{id}")
    public void deleteNotificationById(Long id){
        notificationService.deleteNotificationById(id);
    }

}
