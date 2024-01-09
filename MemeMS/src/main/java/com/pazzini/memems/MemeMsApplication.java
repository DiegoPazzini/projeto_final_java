package com.pazzini.memems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RefreshScope
public class MemeMsApplication {

    // Classe principal que inicia a aplicação Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(MemeMsApplication.class, args);
	}

}
