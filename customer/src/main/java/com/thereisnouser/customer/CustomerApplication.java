package com.thereisnouser.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.thereisnouser.clients")
@SpringBootApplication(
        scanBasePackages = {
                "com.thereisnouser.customer",
                "com.thereisnouser.amqp",
        }
)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
