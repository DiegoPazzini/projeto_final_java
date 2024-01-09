package com.pazzini.memems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuração para personalização da documentação OpenAPI (Swagger) do serviço de Cadastro de Memes.
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Bean que cria e retorna uma instância personalizada da documentação OpenAPI.
     *
     * @param appVersion A versão da aplicação obtida a partir das propriedades.
     * @return Uma instância personalizada da documentação OpenAPI.
     */
    @Bean
    OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Serviço de Cadastro de Memes")
                        .version(appVersion)
                        .description("Serviço para cadastro de memes")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(new Contact().name("pazzini Ferreira").email("pazziniferreiram@hotmail.com")));
    }
}
