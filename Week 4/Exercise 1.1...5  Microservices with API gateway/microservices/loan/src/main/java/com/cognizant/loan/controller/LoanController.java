package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Microservice – Loan Controller
 *
 * Exposes a GET endpoint returning dummy car loan details for a loan number.
 * Runs on port 8081 so it can coexist with account-service on 8080.
 *
 * Endpoint : GET /loans/{number}
 * Sample   : GET /loans/H00987987972342
 */
@RestController
@RequestMapping("/loans")
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    /**
     * Returns dummy loan account details for the given loan number.
     *
     * @param number  loan account number from the URL path
     * @return a map serialised to JSON by Spring
     */
    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        LOGGER.info("START getLoanDetails, number={}", number);

        Map<String, Object> loan = new HashMap<>();
        loan.put("number", number);
        loan.put("type", "car");
        loan.put("loan", 400000);
        loan.put("emi", 3258);
        loan.put("tenure", 18);

        LOGGER.debug("Returning loan: {}", loan);
        LOGGER.info("END getLoanDetails");
        return loan;
    }
}
