package com.pazzini.memems.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Configuração para fornecer uma instância do Validador (Validator) do Bean Validation.
 */
@Configuration
public class ValidatorConfig {

    /**
     * Bean que cria e retorna uma instância do Validador (Validator) do Bean Validation.
     *
     * @return Uma instância do Validador do Bean Validation configurada localmente.
     */
    @Bean
    Validator validatorFactory() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean;
    }
}
