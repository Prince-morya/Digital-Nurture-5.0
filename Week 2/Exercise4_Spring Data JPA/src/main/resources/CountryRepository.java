package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Country data access.
 *
 * Extends JpaRepository which provides built-in methods like:
 *   findAll(), findById(), save(), deleteById() — no boilerplate needed.
 *
 * Spring Data JPA generates the implementation at runtime automatically.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     * Hands-on 5 – find countries whose name contains a keyword (case-insensitive).
     *
     * Spring Data JPA derives the SQL from the method name automatically:
     * SELECT * FROM country WHERE LOWER(co_name) LIKE LOWER('%keyword%')
     */
    List<Country> findByNameContainingIgnoreCase(String keyword);
}
