package com.thereisnouser.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
