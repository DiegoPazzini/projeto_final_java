package com.pazzini.categoriaMemeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Classe principal que inicia a aplicação Spring Boot para o serviço de Categoria de Memes.
 */
@SpringBootApplication
@EnableFeignClients // Habilita o suporte a clientes Feign para facilitar a comunicação entre serviços
@EnableDiscoveryClient // Habilita o registro no serviço de descoberta (por exemplo, Eureka)
@RefreshScope // Habilita o suporte ao RefreshScope para atualizações dinâmicas de propriedades
public class CategoriaMemeServiceApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(CategoriaMemeServiceApplication.class, args);
    }

}
