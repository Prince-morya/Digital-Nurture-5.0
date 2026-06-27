package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // ── Constructor ───────────────────────────────────────────────────────────

    public Country() {
        LOGGER.debug("Inside Country Constructor");
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public String getCode() {
        LOGGER.debug("Inside getCode, code={}", code);
        return code;
    }

    public String getName() {
        LOGGER.debug("Inside getName, name={}", name);
        return name;
    }

    // ── Setters ───────────────────────────────────────────────────────────────

    public void setCode(String code) {
        LOGGER.debug("Inside setCode, code={}", code);
        this.code = code;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName, name={}", name);
        this.name = name;
    }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
