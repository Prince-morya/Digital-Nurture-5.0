package com.cognizant.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Discovery Server – Entry Point
 *
 * @EnableEurekaServer turns this Spring Boot app into a service registry.
 * Once running, open http://localhost:8761 in the browser to view
 * which services are currently registered.
 *
 * Start order:
 *   1. This server first  (wait until fully started)
 *   2. account-service
 *   3. loan-service
 *   4. api-gateway
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaDiscoveryServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
        LOGGER.info("Eureka Discovery Server started – visit http://localhost:8761");
    }
}
