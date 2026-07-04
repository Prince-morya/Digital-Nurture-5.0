package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The country list is loaded once from the Spring XML configuration and kept
 * in memory - there is no real persistence layer for this hands-on exercise.
 */
@Repository
public class CountryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);

    private final List<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryDao() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countryList = (List<Country>) context.getBean("countryList", List.class);
        LOGGER.info("End");
    }

    public List<Country> getAllCountries() {
        return countryList;
    }
}
