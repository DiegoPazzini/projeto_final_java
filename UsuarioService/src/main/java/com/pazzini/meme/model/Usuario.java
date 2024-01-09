package com.pazzini.meme.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A classe representa a entidade "Usuario" no sistema, que é mapeada para o MongoDB.
 * Contém informações sobre o usuário, como identificação única, nome, e-mail e data de cadastro.
 */
@Document(collection = "usuario")
@Schema(name = "Usuario", description = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotBlank
    @Size(min = 1, max = 50)
    @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
    private String nome;

    @Email(message = "Email inválido.")
    @Indexed(unique = true, background = true)
    @Schema(description = "E-mail", minLength = 1, maxLength = 50, nullable = false)
    private String email;

    @NotNull
    private LocalDateTime dataCadastro;

    /**
     * Construtor padrão sem argumentos.
     */
    public Usuario() {
    }

    /**
     * Construtor que inicializa um objeto Usuario com nome, email e data de cadastro.
     *
     * @param nome          O nome do usuário.
     * @param email         O endereço de e-mail do usuário.
     * @param dataCadastro  A data de cadastro do usuário.
     */
    public Usuario(String nome, String email, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    /**
     * Obtém o identificador único do usuário.
     *
     * @return O identificador único do usuário.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     *
     * @param id O identificador único do usuário.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço de e-mail do usuário.
     *
     * @return O endereço de e-mail do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do usuário.
     *
     * @param email O endereço de e-mail do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a data de cadastro do usuário.
     *
     * @return A data de cadastro do usuário.
     */
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Define a data de cadastro do usuário.
     *
     * @param dataCadastro A data de cadastro do usuário.
     */
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Calcula o código hash do objeto com base no identificador único.
     *
     * @return O código hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Verifica se dois objetos Usuario são iguais com base no identificador único.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

    /**
     * Retorna uma representação de string do objeto.
     *
     * @return Uma representação de string do objeto.
     */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", dataCadastro=" + dataCadastro + "]";
    }

}
