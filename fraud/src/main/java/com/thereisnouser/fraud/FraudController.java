package com.thereisnouser.fraud;


import com.thereisnouser.clients.fraud.FraudCheckResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        final boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulent);
    }
}
