package com.pazzini.memems.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.pazzini.memems.config.Groups;

/**
 * Classe que representa uma Categoria de Meme.
 */
public class CategoriaMeme implements Serializable {

    private static final long serialVersionUID = 1L;

    // Identificador único
    @NotBlank(groups = Groups.CadastroMeme.class)
    private String id;

    // Nome da categoria (obrigatório)
    private String nome;

    // Descrição da categoria (obrigatório)
    private String descricao;

    // Data do cadastro (obrigatório)
    private LocalDateTime dataCadastro;

    // Usuário responsável pela categoria
    private Usuario usuario;

    public CategoriaMeme() {
    }

    // Construtor com parâmetros
    public CategoriaMeme(String nome, String descricao, LocalDateTime dataCadastro, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }

    // Getters e Setters omitidos para brevidade

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
        CategoriaMeme other = (CategoriaMeme) obj;
        return Objects.equals(id, other.id);
    }

}
