package com.cognizant.ormlearn.service.exception;

/**
 * Thrown when a country lookup by code yields no result.
 *
 * Extends Exception (checked) so callers are forced to handle it explicitly,
 * making the error path clear at compile time.
 */
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(String countryCode) {
        super("No country found with code: " + countryCode);
    }
}
