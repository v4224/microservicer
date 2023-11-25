package com.thereisnouser.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Long customerId) {
        final boolean isFraudster = false;
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(isFraudster)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return isFraudster;
    }
}
