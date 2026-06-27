package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Entry point for the spring-learn project.
 *
 * Each hands-on exercise has its own clearly named method.
 * Comment/uncomment the calls in main() to run only what you need.
 *
 * HO-1 : Project creation + startup log       → main()
 * HO-2 : Load SimpleDateFormat from XML       → displayDate()
 * HO-3 : Logging setup                        → already applied throughout
 * HO-4 : Load Country from XML                → displayCountry()
 * HO-5 : Singleton vs Prototype scope         → demonstrateScope()
 * HO-6 : Load list of countries from XML      → displayCountries()
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main – Spring Boot application started successfully");

        // ── Uncomment the exercise you want to run ────────────────────────────
        displayDate();          // Hands-on 2
        displayCountry();       // Hands-on 4
        demonstrateScope();     // Hands-on 5
        displayCountries();     // Hands-on 6
    }

    // ── Hands-on 2 : Load SimpleDateFormat from Spring XML config ─────────────

    /**
     * Creates an ApplicationContext from date-format.xml,
     * retrieves the SimpleDateFormat bean, and parses a date string.
     *
     * Key concepts: ClassPathXmlApplicationContext, getBean(), constructor-arg in XML
     */
    private static void displayDate() {
        LOGGER.info("START displayDate");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Failed to parse date – {}", e.getMessage());
        }
        LOGGER.info("END displayDate");
    }

    // ── Hands-on 4 : Load Country from Spring XML config ──────────────────────

    /**
     * Loads a single Country bean from country.xml using setter injection.
     * Observe in the logs that setCode() and setName() are called by Spring.
     *
     * Key concepts: <property> tag, setter injection, getBean()
     */
    private static void displayCountry() {
        LOGGER.info("START displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country: {}", country.toString());
        LOGGER.info("END displayCountry");
    }

    // ── Hands-on 5 : Singleton vs Prototype scope ─────────────────────────────

    /**
     * Calls getBean() twice and compares the references.
     *
     * Singleton  (default) : constructor logged ONCE  → same object returned
     * Prototype  (scope="prototype" in XML) : constructor logged TWICE → new object each time
     *
     * To see prototype behaviour: open country.xml and change scope="singleton" to scope="prototype"
     */
    private static void demonstrateScope() {
        LOGGER.info("START demonstrateScope");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country firstBean  = context.getBean("country", Country.class);
        Country secondBean = context.getBean("country", Country.class);

        boolean sameInstance = (firstBean == secondBean);
        LOGGER.debug("firstBean  : {}", firstBean);
        LOGGER.debug("secondBean : {}", secondBean);
        LOGGER.debug("Same instance? {} (true = singleton, false = prototype)", sameInstance);
        LOGGER.info("END demonstrateScope");
    }

    // ── Hands-on 6 : Load list of countries from Spring XML config ────────────

    /**
     * Loads the ArrayList<Country> bean (countryList) from country.xml.
     * The list references four individual country beans: in, us, de, jp.
     *
     * Key concepts: <list>, <ref bean="...">, ArrayList as a Spring bean
     */
    @SuppressWarnings("unchecked")
    private static void displayCountries() {
        LOGGER.info("START displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);
        LOGGER.debug("Total countries loaded: {}", countries.size());
        countries.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("END displayCountries");
    }
}
