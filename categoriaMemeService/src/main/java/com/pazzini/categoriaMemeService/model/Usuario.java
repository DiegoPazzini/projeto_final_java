package com.pazzini.categoriaMemeService.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.pazzini.categoriaMemeService.config.Groups;

/**
 * Entidade que representa um usuário no sistema.
 */
public class Usuario {

    // Identificador único do usuário, obrigatório para cadastro de categoria
    @NotBlank(groups = Groups.CadastroCategoria.class)
    private String id;

    // Nome do usuário
    private String nome;

    // E-mail do usuário
    private String email;

    // Data de cadastro do usuário
    private LocalDate dataCadastro;

    /**
     * Construtor padrão sem argumentos.
     */
    public Usuario() {
    }

    /**
     * Construtor que recebe parâmetros para inicializar os campos do usuário.
     *
     * @param id            O identificador único do usuário.
     * @param nome          O nome do usuário.
     * @param email         O e-mail do usuário.
     * @param dataCadastro  A data de cadastro do usuário.
     */
    public Usuario(String id, String nome, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    // Métodos de acesso para os campos da entidade

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Métodos padrão para hashCode e equals utilizando apenas o ID

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
}
