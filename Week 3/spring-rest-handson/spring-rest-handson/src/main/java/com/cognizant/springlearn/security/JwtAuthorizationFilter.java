package com.cognizant.springlearn.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    private final JwtSupport jwtSupport;

    public JwtAuthorizationFilter(JwtSupport jwtSupport) {
        this.jwtSupport = jwtSupport;
        LOGGER.info("Start");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.info("Start");
        String header = req.getHeader(HEADER);
        LOGGER.debug("Authorization header: {}", header);

        if (header == null || !header.startsWith(PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        String token = header.substring(PREFIX.length());
        Optional<String> user = jwtSupport.getUser(token);

        user.ifPresent(username -> {
            var authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });

        chain.doFilter(req, res);
        LOGGER.info("End");
    }
}
