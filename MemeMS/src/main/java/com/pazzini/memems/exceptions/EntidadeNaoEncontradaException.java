package com.pazzini.memems.exceptions;

/**
 * Exceção personalizada para representar casos em que uma entidade não é encontrada.
 */
public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre o erro.
     *
     * @param mensagem A mensagem detalhando a razão da exceção.
     */
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
