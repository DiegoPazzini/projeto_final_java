package com.pazzini.gatewaymeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Classe principal que inicia a aplicação Spring Boot para o serviço de Gateway Meme.
 */
@SpringBootApplication
@EnableDiscoveryClient // Habilita o registro no serviço de descoberta (por exemplo, Eureka)
public class GatewayMemeApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot do Gateway Meme.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayMemeApplication.class, args);
    }

}
