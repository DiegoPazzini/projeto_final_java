package com.pazzini.memems.exceptions;

/**
 * Exceção personalizada para representar casos em que uma entidade está em uso e não pode ser removida.
 */
public class EntidadeEmUsoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre o erro.
     *
     * @param mensagem A mensagem detalhando a razão da exceção.
     */
    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }

}
