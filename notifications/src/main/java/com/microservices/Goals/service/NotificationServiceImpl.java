package com.microservices.Goals.service;

import com.microservices.Goals.exception.ResourceNotFoundException;
import com.microservices.Goals.model.Notification;
import com.microservices.Goals.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }
    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long idNotification) {
        return notificationRepository.findById(idNotification).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" + idNotification ));
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteNotification(Long idNotification) {
        notificationRepository.deleteById(idNotification);
    }

}
