package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for all Country-related business operations.
 *
 * Each method is annotated with @Transactional so Spring manages the
 * Hibernate session and transaction lifecycle — no manual begin/commit/rollback.
 *
 * Hands-on exercises covered:
 *   HO-1  : getAllCountries()
 *   HO-5  : searchCountriesByName()
 *   HO-6  : findCountryByCode()
 *   HO-7  : addCountry()
 *   HO-8  : updateCountry()
 *   HO-9  : deleteCountry()
 */
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    // Constructor injection is preferred over field injection (SOLID – DIP)
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // ── Hands-on 1 ───────────────────────────────────────────────────────────

    /**
     * Returns every country stored in the database.
     */
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // ── Hands-on 5 ───────────────────────────────────────────────────────────

    /**
     * Returns countries whose name contains the given keyword (case-insensitive).
     *
     * @param keyword  partial name to search for, e.g. "land"
     */
    @Transactional
    public List<Country> searchCountriesByName(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    // ── Hands-on 6 ───────────────────────────────────────────────────────────

    /**
     * Finds a single country by its ISO 3166-1 alpha-2 code.
     *
     * @param countryCode  e.g. "IN", "US"
     * @throws CountryNotFoundException when no matching row exists
     */
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException(countryCode);
        }

        return result.get();
    }

    // ── Hands-on 7 ───────────────────────────────────────────────────────────

    /**
     * Persists a new Country record.
     *
     * @param country  country object to insert
     */
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // ── Hands-on 8 ───────────────────────────────────────────────────────────

    /**
     * Updates the name of an existing country identified by code.
     *
     * @param countryCode  code of the country to update
     * @param newName      new display name to apply
     * @throws CountryNotFoundException when the code does not exist
     */
    @Transactional
    public void updateCountry(String countryCode, String newName) throws CountryNotFoundException {
        Country country = findCountryByCode(countryCode);
        country.setName(newName);
        countryRepository.save(country);
    }

    // ── Hands-on 9 ───────────────────────────────────────────────────────────

    /**
     * Deletes the country identified by code.
     *
     * @param countryCode  code of the country to remove
     */
    @Transactional
    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }
}
