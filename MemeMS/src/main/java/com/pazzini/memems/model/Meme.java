package com.pazzini.memems.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe que representa um Meme.
 */
@Document(collection = "meme")
@Schema(name = "Meme", description = "Meme")
public class Meme implements Serializable {

    private static final long serialVersionUID = 1L;

    // Identificador único
    @Id
    @Schema(description = "Identificador único")
    private String id;

    // Nome do meme (obrigatório)
    @NotBlank
    @Schema(description = "Nome", nullable = false)
    private String nome;

    // Descrição do meme (obrigatória)
    @NotBlank
    @Schema(description = "Descrição", nullable = false)
    private String descricao;

    // URL do meme (obrigatória)
    @NotBlank
    @Schema(description = "URL", nullable = false)
    private String url;

    // Data do cadastro (obrigatória)
    @Schema(description = "Data do cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    // Categoria do meme (ignorada na serialização)
    @JsonIgnore
    @Valid
    @NotNull
    private CategoriaMeme categoria;

    // Usuário responsável pelo meme (ignorado na serialização)
    @JsonIgnore
    @Valid
    @NotNull
    private Usuario usuario;

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
        Meme other = (Meme) obj;
        return Objects.equals(id, other.id);
    }

}
