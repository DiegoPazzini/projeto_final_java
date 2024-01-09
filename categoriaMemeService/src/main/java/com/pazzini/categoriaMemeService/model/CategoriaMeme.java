package com.pazzini.categoriaMemeService.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entidade que representa uma categoria de meme no sistema.
 */
@Document(collection = "categoriaMeme")
@Schema(name = "CategoriaMeme", description = "Categoria Meme")
public class CategoriaMeme {

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotBlank
    @Size(min = 1, max = 50)
    @Schema(description = "Nome", nullable = false)
    private String nome;

    @NotBlank
    @Size(min = 1, max = 100)
    @Schema(description = "Descricao", nullable = false)
    private String descricao;

    @NotBlank
    @Schema(description = "Data do cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @NotNull
    @JsonIgnore
    private Usuario usuario;

    /**
     * Construtor padrão sem argumentos.
     */
    public CategoriaMeme() {
    }

    /**
     * Construtor que recebe parâmetros para inicializar os campos da categoria de meme.
     *
     * @param nome          O nome da categoria de meme.
     * @param descricao     A descrição da categoria de meme.
     * @param dataCadastro  A data de cadastro da categoria de meme.
     * @param usuario       O usuário associado à categoria de meme.
     */
    public CategoriaMeme(String nome, String descricao, LocalDateTime dataCadastro, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para obter o ID do usuário associado (utilizado para a serialização JSON)
    @JsonProperty("usuarioId")
    public String getUsuarioId() {
        return usuario != null ? usuario.getId() : null;
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
        CategoriaMeme other = (CategoriaMeme) obj;
        return Objects.equals(id, other.id);
    }
}
