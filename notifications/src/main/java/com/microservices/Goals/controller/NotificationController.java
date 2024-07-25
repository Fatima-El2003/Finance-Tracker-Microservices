package com.microservices.Goals.controller;

import com.microservices.Goals.model.Notification;
import com.microservices.Goals.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
     private final NotificationService notificationService;
     @Autowired
     public NotificationController(final NotificationService notificationService) {
         this.notificationService = notificationService;
     }
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.addNotification(notification);
        return ResponseEntity.ok(savedNotification);
    }
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
         return ResponseEntity.ok(notificationService.getAllNotifications());
    }
    @DeleteMapping("{idNotification}")
    public ResponseEntity<String> deleteNotification(@PathVariable("idNotification") Long idNotification) {
        notificationService.deleteNotification(idNotification);
         return ResponseEntity.ok("Notification Deleted");
    }
}
