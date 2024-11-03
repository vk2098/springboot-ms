package com.microservices.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientRequest;

import java.net.http.HttpRequest;

@Configuration
public class CustomFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Logs the request URI
        logger.info("Pre-filter: Incoming request for URL: {}", exchange.getRequest().getURI());

        // Accessing the Authorization header
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            logger.info("Authorization header: {}", authorizationHeader);
        // Pass control to the next filter in the chain
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // Log the response status code
            logger.info("Post-filter: Response status code: {}", exchange.getResponse().getStatusCode());

            // Example: Add a custom header to the response
            exchange.getResponse().getHeaders().add("X-Custom-Header", "CustomResponseHeaderValue");
        }));
    }

}
