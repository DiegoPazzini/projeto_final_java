package com.pazzini.categoriaMemeService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuração responsável por definir a documentação OpenAPI para o serviço de Categoria dos Memes.
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Cria um Bean para configurar o objeto OpenAPI personalizado.
     *
     * @param appVersion A versão da aplicação, que é injetada a partir das propriedades de aplicação.
     * @return Uma instância personalizada de OpenAPI com informações sobre o serviço.
     */
    @Bean
    OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Serviço de Categoria dos Memes")
                        .version(appVersion) // Define a versão da aplicação
                        .description("Serviço para cadastro das categorias dos memes") // Descrição do serviço
                        .termsOfService("http://swagger.io/terms/") // URL dos termos de serviço
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")) // Informações de licença
                        .contact(new Contact().name("pazzini diego").email("pazzinidiego@hotmail.com"))); // Informações de contato
    }
}
