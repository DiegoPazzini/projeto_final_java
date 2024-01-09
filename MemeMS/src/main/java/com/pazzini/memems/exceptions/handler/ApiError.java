package com.pazzini.memems.exceptions.handler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe que representa uma resposta de erro da API, fornecendo informações detalhadas sobre o erro ocorrido.
 */
@JsonInclude(Include.NON_NULL)
public class ApiError {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private LocalDateTime timestamp;
    private List<Field> fields;

    /**
     * Obtém o código de status HTTP associado ao erro.
     *
     * @return O código de status HTTP.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Define o código de status HTTP associado ao erro.
     *
     * @param status O código de status HTTP.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Obtém o tipo de erro.
     *
     * @return O tipo de erro.
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo de erro.
     *
     * @param type O tipo de erro.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtém o título do erro.
     *
     * @return O título do erro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do erro.
     *
     * @param title O título do erro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém os detalhes do erro.
     *
     * @return Os detalhes do erro.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Define os detalhes do erro.
     *
     * @param detail Os detalhes do erro.
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Obtém o timestamp (data e hora) em que o erro ocorreu.
     *
     * @return O timestamp do erro.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Define o timestamp (data e hora) em que o erro ocorreu.
     *
     * @param timestamp O timestamp do erro.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtém a lista de campos associados ao erro, contendo o nome do campo e a mensagem de erro do usuário.
     *
     * @return A lista de campos associados ao erro.
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Define a lista de campos associados ao erro, contendo o nome do campo e a mensagem de erro do usuário.
     *
     * @param fields A lista de campos associados ao erro.
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * Classe interna que representa um campo associado ao erro, contendo o nome do campo e a mensagem de erro do usuário.
     */
    public static class Field {
        private String name;
        private String userMessage;

        /**
         * Construtor padrão da classe Field.
         */
        public Field() {
        }

        /**
         * Construtor que inicializa um objeto Field com o nome do campo e a mensagem de erro do usuário.
         *
         * @param name        O nome do campo.
         * @param userMessage A mensagem de erro do usuário.
         */
        public Field(String name, String userMessage) {
            super();
            this.name = name;
            this.userMessage = userMessage;
        }

        /**
         * Obtém o nome do campo associado ao erro.
         *
         * @return O nome do campo.
         */
        public String getName() {
            return name;
        }

        /**
         * Define o nome do campo associado ao erro.
         *
         * @param name O nome do campo.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Obtém a mensagem de erro do usuário associada ao campo.
         *
         * @return A mensagem de erro do usuário.
         */
        public String getUserMessage() {
            return userMessage;
        }

        /**
         * Define a mensagem de erro do usuário associada ao campo.
         *
         * @param userMessage A mensagem de erro do usuário.
         */
        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

    }

}
