package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Application entry point.
 *
 * Each hands-on exercise has its own clearly named private static test method.
 * Call the one(s) you want from main() and comment the rest out while working.
 *
 * @SpringBootApplication enables:
 *   @Configuration  – marks this as a Spring config source
 *   @EnableAutoConfiguration – auto-wires Spring Boot defaults (JPA, DataSource…)
 *   @ComponentScan  – scans sub-packages for @Service, @Repository, etc.
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    // Resolved from the ApplicationContext after startup
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        LOGGER.info("Inside main – application started successfully");

        // ── Run the hands-on you want to test (comment/uncomment as needed) ──
        testGetAllCountries();           // Hands-on 1
        testSearchCountriesByName();     // Hands-on 5
        testFindCountryByCode();         // Hands-on 6
        testAddCountry();                // Hands-on 7
        testUpdateCountry();             // Hands-on 8
        testDeleteCountry();             // Hands-on 9
    }

    // ── Hands-on 1 : Get all countries ───────────────────────────────────────

    private static void testGetAllCountries() {
        LOGGER.info("=== Hands-on 1 : testGetAllCountries START ===");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries fetched: {}", countries.size());
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("=== Hands-on 1 : testGetAllCountries END ===");
    }

    // ── Hands-on 5 : Search countries by partial name ────────────────────────

    private static void testSearchCountriesByName() {
        LOGGER.info("=== Hands-on 5 : testSearchCountriesByName START ===");
        String keyword = "land";
        List<Country> matches = countryService.searchCountriesByName(keyword);
        LOGGER.debug("Countries containing '{}': {}", keyword, matches.size());
        matches.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("=== Hands-on 5 : testSearchCountriesByName END ===");
    }

    // ── Hands-on 6 : Find by country code ────────────────────────────────────

    private static void testFindCountryByCode() {
        LOGGER.info("=== Hands-on 6 : testFindCountryByCode START ===");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country found: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Lookup failed – {}", e.getMessage());
        }
        LOGGER.info("=== Hands-on 6 : testFindCountryByCode END ===");
    }

    // ── Hands-on 7 : Add a new country ───────────────────────────────────────

    private static void testAddCountry() {
        LOGGER.info("=== Hands-on 7 : testAddCountry START ===");

        Country newCountry = new Country("ZZ", "Test Nation");
        countryService.addCountry(newCountry);
        LOGGER.debug("Country added: {}", newCountry);

        // Verify the insert by reading it back
        try {
            Country saved = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Verification – country retrieved after insert: {}", saved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Verification failed – {}", e.getMessage());
        }

        LOGGER.info("=== Hands-on 7 : testAddCountry END ===");
    }

    // ── Hands-on 8 : Update a country name ───────────────────────────────────

    private static void testUpdateCountry() {
        LOGGER.info("=== Hands-on 8 : testUpdateCountry START ===");
        try {
            countryService.updateCountry("ZZ", "Updated Test Nation");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Country after update: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Update failed – {}", e.getMessage());
        }
        LOGGER.info("=== Hands-on 8 : testUpdateCountry END ===");
    }

    // ── Hands-on 9 : Delete a country ────────────────────────────────────────

    private static void testDeleteCountry() {
        LOGGER.info("=== Hands-on 9 : testDeleteCountry START ===");
        countryService.deleteCountry("ZZ");
        LOGGER.debug("Country with code 'ZZ' deleted");

        // Confirm deletion — should throw CountryNotFoundException
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.warn("Expected CountryNotFoundException but country still exists!");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Confirmed – country no longer exists: {}", e.getMessage());
        }
        LOGGER.info("=== Hands-on 9 : testDeleteCountry END ===");
    }
}
