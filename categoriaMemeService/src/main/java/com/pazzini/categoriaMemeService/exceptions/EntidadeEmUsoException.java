package com.pazzini.categoriaMemeService.exceptions;

/**
 * Exceção personalizada que representa a situação em que uma entidade está sendo utilizada e não pode ser removida.
 */
public class EntidadeEmUsoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem explicativa sobre a exceção.
     *
     * @param mensagem A mensagem explicativa sobre a exceção.
     */
    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
