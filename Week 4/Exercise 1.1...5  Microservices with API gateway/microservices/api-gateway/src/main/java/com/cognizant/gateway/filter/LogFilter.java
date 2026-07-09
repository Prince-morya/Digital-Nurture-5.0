package com.cognizant.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global filter applied to every request passing through the API Gateway.
 *
 * Implements GlobalFilter so Spring Cloud Gateway picks it up automatically —
 * no route-specific wiring needed.
 *
 * What it does:
 *   - Logs the full URI of every incoming request before forwarding it.
 *   - Passes the request along by calling chain.filter(exchange).
 *
 * After running, check the api-gateway console for log lines like:
 *   ====> Request URL http://localhost:9090/account-service/accounts/123
 */
@Component
public class LogFilter implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("====> Request URL {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
