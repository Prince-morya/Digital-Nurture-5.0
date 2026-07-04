package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String BASIC_PREFIX = "Basic ";

    private final AuthenticationManager authenticationManager;
    private final JwtSupport jwtSupport;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtSupport jwtSupport) {
        this.authenticationManager = authenticationManager;
        this.jwtSupport = jwtSupport;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader: {}", authHeader);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");

        String[] credentials = decodeCredentials(authHeader);
        if (credentials != null) {
            // Verifies the username/password against the users configured in
            // SecurityConfig before a token is ever handed out.
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials[0], credentials[1]));

            String token = jwtSupport.generateToken(credentials[0]);
            map.put("token", token);
        }

        LOGGER.info("End");
        return map;
    }

    private String[] decodeCredentials(String authHeader) {
        if (authHeader == null || !authHeader.startsWith(BASIC_PREFIX)) {
            return null;
        }

        String encodedCredentials = authHeader.substring(BASIC_PREFIX.length());
        String decoded = new String(Base64.getDecoder().decode(encodedCredentials), StandardCharsets.UTF_8);
        LOGGER.debug("Decoded credentials: {}", decoded);

        int separatorIndex = decoded.indexOf(':');
        if (separatorIndex < 0) {
            return null;
        }

        return new String[] { decoded.substring(0, separatorIndex), decoded.substring(separatorIndex + 1) };
    }
}
