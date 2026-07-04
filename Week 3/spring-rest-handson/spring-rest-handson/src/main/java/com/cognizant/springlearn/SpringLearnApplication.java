package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start");
        SpringApplication.run(SpringLearnApplication.class, args);

        // Hands-on 2, 4, 5, 6: simple demos of loading beans from XML config.
        // These are independent of the running web server and only print to
        // the console/log so they can be reviewed alongside the REST services.
        displayDate();
        displayCountry();
        displaySingletonVsPrototype();
        displayCountries();

        LOGGER.info("End");
    }

    /** Hands-on 2: load a shared SimpleDateFormat bean from date-format.xml. */
    private static void displayDate() {
        LOGGER.info("Start");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            var date = format.parse("31/12/2018");
            LOGGER.debug("Parsed date: {}", date);
        } catch (Exception ex) {
            LOGGER.warn("Could not parse sample date", ex);
        }
        LOGGER.info("End");
    }

    /** Hands-on 4: load a single Country bean from country.xml. */
    private static void displayCountry() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.debug("Country : {}", country);
        LOGGER.info("End");
    }

    /** Hands-on 5: demonstrates singleton (default) scope for the country bean. */
    private static void displaySingletonVsPrototype() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        Country anotherCountry = context.getBean("in", Country.class);
        LOGGER.debug("Same instance returned (singleton scope): {}", country == anotherCountry);
        LOGGER.info("End");
    }

    /** Hands-on 6: load the full list of countries from country.xml. */
    @SuppressWarnings("unchecked")
    private static void displayCountries() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList", List.class);
        countries.forEach(country -> LOGGER.debug("Country : {}", country));
        LOGGER.info("End");
    }
}
