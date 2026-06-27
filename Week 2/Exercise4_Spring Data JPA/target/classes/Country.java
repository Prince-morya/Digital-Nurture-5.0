package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistence class that maps to the 'country' table in the ormlearn schema.
 *
 * Annotations used:
 *   @Entity  – marks this class as a JPA-managed entity
 *   @Table   – specifies the exact table name to bind to
 *   @Id      – designates the primary key field
 *   @Column  – maps each field to its corresponding column name
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // ── Constructors ──────────────────────────────────────────────────────────

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
