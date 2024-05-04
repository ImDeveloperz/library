package com.project.bibliotheque.services;

import com.project.bibliotheque.dtos.NotificationDto;
import com.project.bibliotheque.entities.Notification;
import com.project.bibliotheque.mappers.NotificationMapper;
import com.project.bibliotheque.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper){
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
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
}
