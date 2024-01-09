package com.pazzini.categoriaMemeService.exceptions;

/**
 * Exceção personalizada que representa a situação em que uma entidade não é encontrada.
 */
public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre a exceção.
     *
     * @param mensagem A mensagem explicativa sobre a exceção.
     */
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
