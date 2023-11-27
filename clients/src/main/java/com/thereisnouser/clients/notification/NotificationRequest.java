package com.thereisnouser.clients.notification;

public record NotificationRequest(
        String message,
        String sender,
        String toCustomerEmail
) {
}
