package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Microservice – Account Controller
 *
 * Exposes a single GET endpoint that returns dummy account details for a
 * given account number. No database involved — the focus is on REST structure
 * and Eureka registration, not on persistence.
 *
 * Endpoint : GET /accounts/{number}
 * Sample   : GET /accounts/00987987973432
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    /**
     * Returns a dummy savings account for the given account number.
     *
     * @param number  account number from the URL path
     * @return a map that Spring serialises to JSON automatically
     */
    @GetMapping("/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        LOGGER.info("START getAccountDetails, number={}", number);

        Map<String, Object> account = new HashMap<>();
        account.put("number", number);
        account.put("type", "savings");
        account.put("balance", 234343);

        LOGGER.debug("Returning account: {}", account);
        LOGGER.info("END getAccountDetails");
        return account;
    }
}
