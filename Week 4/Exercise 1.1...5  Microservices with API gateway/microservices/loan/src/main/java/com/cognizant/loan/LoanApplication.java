package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Loan Microservice – Entry Point
 *
 * Runs on port 8081 (configured in application.properties).
 * Registers itself with Eureka as "loan-service".
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LoanApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
        LOGGER.info("Loan microservice started on port 8081");
    }
}
