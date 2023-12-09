package com.thereisnouser.customer;

import com.thereisnouser.amqp.RabbitMQMessageProducer;
import com.thereisnouser.clients.fraud.FraudCheckResponse;
import com.thereisnouser.clients.fraud.FraudClient;
import com.thereisnouser.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        FraudClient fraudClient,
        RabbitMQMessageProducer rabbitMQMessageProducer
) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException(MessageFormat.format("customer {0} is fraudster", customer.getId()));
        }

        final NotificationRequest notificationRequest = new NotificationRequest(
                MessageFormat.format("Hi, {0}! welcome to our server!", customer.getFirstName()),
                "Admin",
                customer.getEmail()
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
