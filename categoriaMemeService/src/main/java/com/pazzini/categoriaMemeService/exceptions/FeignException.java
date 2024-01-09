package com.pazzini.categoriaMemeService.exceptions;

/**
 * Exceção personalizada que representa uma situação de erro ou exceção ao usar Feign.
 */
public class FeignException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre a exceção.
     *
     * @param mensagem A mensagem explicativa sobre a exceção.
     */
    public FeignException(String mensagem) {
        super(mensagem);
    }
}
