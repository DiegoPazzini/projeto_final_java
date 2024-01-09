package com.samuel.gatewaymeme.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do Gateway para rotear solicitações para serviços específicos.
 */
@Configuration
public class GatewayConfig {

    /**
     * Bean que configura o roteamento personalizado para diferentes serviços.
     *
     * @param builder O construtor do RouteLocator para criar rotas.
     * @return Um objeto RouteLocator configurado com as rotas personalizadas.
     */
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("usuarios", r -> r
                        .path("/usuarios/**")
                        .uri("http://localhost:8000"))
                .route("categorias", r -> r
                        .path("/categorias/**")
                        .uri("http://localhost:8200"))
                .route("memes", r -> r
                        .path("/memes/**")
                        .uri("http://localhost:8100"))
                .build();
    }
}
