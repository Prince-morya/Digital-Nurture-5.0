package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

/**
 * Small wrapper around the jjwt library so the token creation/validation logic
 * lives in one place instead of being duplicated between the authenticate
 * endpoint and the authorization filter.
 */
@Component
public class JwtSupport {

    // In a real project this would come from an external secret store / vault,
    // not be hard coded. Kept here to match the training exercise.
    private static final String SECRET = "spring-learn-training-secret-key-must-be-long-enough";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private static final long TOKEN_VALIDITY_MS = 20 * 60 * 1000; // 20 minutes

    public String generateToken(String user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + TOKEN_VALIDITY_MS);

        return Jwts.builder()
                .subject(user)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(KEY)
                .compact();
    }

    public Optional<String> getUser(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return Optional.ofNullable(claims.getSubject());
        } catch (JwtException | IllegalArgumentException ex) {
            return Optional.empty();
        }
    }
}
