package com.cognizant.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * API Gateway – Entry Point
 *
 * Routes all incoming requests to the appropriate microservice using
 * Eureka service discovery. The LogFilter intercepts every request
 * and logs the URL before forwarding.
 *
 * Test URLs (after all services are up):
 *   http://localhost:9090/account-service/accounts/00987987973432
 *   http://localhost:9090/loan-service/loans/H00987987972342
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        LOGGER.info("API Gateway started on port 9090");
    }
}
