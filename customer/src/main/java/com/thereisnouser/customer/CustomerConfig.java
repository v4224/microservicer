package com.thereisnouser.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // https://stackoverflow.com/a/65724088
    /*
     * // https://www.appsdeveloperblog.com/micrometer-and-zipkin-in-spring-boot/
     * //     -> Tracing HTTP Request Sent with Feign
     * @Bean
     * public Capability capability(final MeterRegistry meterRegistry) {
     *     return new MicrometerCapability(meterRegistry);
     * }
     */
}
