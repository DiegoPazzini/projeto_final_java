package com.pazzini.meme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Ponto de entrada da aplicação de usuários.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class UsuariosApplication {

    /**
     * Método principal que inicia a aplicação de usuários.
     *
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(UsuariosApplication.class, args);
    }

}
