package com.pazzini.categoriaMemeService.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.pazzini.categoriaMemeService.config.Groups;
import com.pazzini.categoriaMemeService.model.Usuario;

/**
 * DTO (Data Transfer Object) representando os dados de uma categoria para operações de entrada/saída.
 */
public class CategoriaDto {

    // Nome da categoria, obrigatório para cadastro
    @NotBlank(groups = Groups.CadastroCategoria.class)
    @NotBlank
    private String nome;

    // Descrição da categoria, obrigatória para cadastro
    @NotBlank(groups = Groups.CadastroCategoria.class)
    @NotBlank
    private String descricao;

    // Usuário associado à categoria, obrigatório para cadastro
    @Valid
    @NotNull(groups = Groups.CadastroCategoria.class)
    private Usuario usuario;

    /**
     * Obtém o nome da categoria.
     *
     * @return O nome da categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da categoria.
     *
     * @param nome O nome a ser definido para a categoria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição da categoria.
     *
     * @return A descrição da categoria.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da categoria.
     *
     * @param descricao A descrição a ser definida para a categoria.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o usuário associado à categoria.
     *
     * @return O usuário associado à categoria.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o usuário associado à categoria.
     *
     * @param usuario O usuário a ser associado à categoria.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
