package com.thereisnouser.notification;

import com.thereisnouser.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .sender(notificationRequest.sender())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .build()
        );
    }
}
