package com.pazzini.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Classe principal que inicia a aplicação Spring Boot para o Config Server.
 */
@SpringBootApplication
@EnableConfigServer // Habilita o suporte ao Config Server
public class ConfigServerApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot do Config Server.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
