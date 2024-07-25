package com.microservices.Goals.service;

import com.microservices.Goals.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification addNotification(Notification notification);
    Notification getNotificationById(Long idNotification);
    List<Notification> getAllNotifications();
    void deleteNotification(Long idNotification);
}
