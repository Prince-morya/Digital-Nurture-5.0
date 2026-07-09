package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Account Microservice – Entry Point
 *
 * @EnableDiscoveryClient registers this service with Eureka so other
 * services and the API Gateway can discover it by name (account-service).
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        LOGGER.info("Account microservice started on port 8080");
    }
}
