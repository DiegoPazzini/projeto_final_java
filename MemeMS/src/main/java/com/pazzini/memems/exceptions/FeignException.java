package com.pazzini.memems.exceptions;

/**
 * Exceção personalizada para representar casos de erro ao utilizar Feign.
 */
public class FeignException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre o erro.
     *
     * @param mensagem A mensagem detalhando a razão da exceção.
     */
    public FeignException(String mensagem) {
        super(mensagem);
    }

}
