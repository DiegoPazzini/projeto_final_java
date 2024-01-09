package com.pazzini.memems.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.pazzini.memems.config.Groups;

/**
 * Classe que representa um Usuário.
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    // Identificador único (obrigatório para cadastro de meme)
    @NotBlank(groups = Groups.CadastroMeme.class)
    private String id;

    // Nome do usuário
    private String nome;

    // Email do usuário
    private String email;

    // Data de cadastro do usuário
    private LocalDate dataCadastro;

    // Construtores e outros métodos omitidos para brevidade

    // Métodos getters e setters omitidos para brevidade

    // Método hashCode e equals para comparar objetos pela propriedade "id"
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

}
