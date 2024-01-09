package com.pazzini.categoriaMemeService.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Configuração responsável por fornecer uma instância do validador para a aplicação.
 */
@Configuration
public class ValidatorConfig {

    /**
     * Cria um Bean para configurar e fornecer um validador local.
     *
     * @return Uma instância de {@link Validator} configurada.
     */
    @Bean
    Validator validatorFactory() {
        // Cria uma fábrica local de validadores
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean; // Retorna a instância configurada do validador
    }
}
