package com.pazzini.categoriaMemeService.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pazzini.categoriaMemeService.config.Groups;
import com.pazzini.categoriaMemeService.dto.CategoriaDto;
import com.pazzini.categoriaMemeService.exceptions.EntidadeNaoEncontradaException;
import com.pazzini.categoriaMemeService.model.CategoriaMeme;
import com.pazzini.categoriaMemeService.repository.ICategoriaRepository;
import com.pazzini.categoriaMemeService.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controlador que gerencia as operações relacionadas às categorias de memes.
 */
@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private CategoriaService categoriaService;
    private ICategoriaRepository categoriaRepository;

    /**
     * Construtor que injeta as dependências necessárias.
     *
     * @param categoriaService      Serviço responsável pela lógica de negócio das categorias.
     * @param categoriaRepository   Repositório utilizado para acessar dados das categorias.
     */
    public CategoriaController(CategoriaService categoriaService, ICategoriaRepository categoriaRepository) {
        this.categoriaService = categoriaService;
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Retorna uma lista de categorias.
     *
     * @return Uma resposta HTTP contendo a lista de categorias e o status OK.
     */
    @GetMapping
    @Operation(summary = "Busca uma página categorias.")
    public ResponseEntity<List<CategoriaMeme>> listar() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaRepository.findAll());
    }

    /**
     * Busca uma categoria pelo ID.
     *
     * @param id O ID da categoria a ser buscada.
     * @return A categoria correspondente ao ID fornecido.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Busca uma categoria pelo ID.")
    public CategoriaMeme buscarPorId(@PathVariable String id) {
        return categoriaService.obterCategoria(id);
    }

    /**
     * Cadastra uma nova categoria.
     *
     * @param categoriaDto A DTO (Data Transfer Object) representando a categoria a ser cadastrada.
     * @return Uma resposta HTTP contendo a categoria recém-cadastrada e o status CREATED.
     */
    @PostMapping
    @Operation(summary = "Cadastra uma categoria.")
    public ResponseEntity<Object> cadastrar(
            @RequestBody @Validated(value = Groups.CadastroCategoria.class) CategoriaDto categoriaDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.cadastrar(categoriaDto));
    }

    /**
     * Atualiza uma categoria existente.
     *
     * @param id           O ID da categoria a ser atualizada.
     * @param categoriaDto A DTO representando os dados atualizados da categoria.
     * @return A categoria atualizada.
     * @throws EntidadeNaoEncontradaException Se a categoria com o ID fornecido não for encontrada.
     */
    @PutMapping("{id}")
    @Operation(summary = "Atualiza uma categoria.")
    public CategoriaMeme atualizar(@PathVariable String id,
                                   @RequestBody @Valid CategoriaDto categoriaDto) {
        try {
            CategoriaMeme categoriaAtual = categoriaService.obterCategoria(id);

            // Copia as propriedades da DTO para a entidade, excluindo "id" e "usuario"
            BeanUtils.copyProperties(categoriaDto, categoriaAtual, "id", "usuario");
            categoriaAtual.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));

            return categoriaService.atualizar(categoriaAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new EntidadeNaoEncontradaException(e.getMessage());
        }
    }

    /**
     * Remove uma categoria pelo ID.
     *
     * @param id O ID da categoria a ser removida.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove uma categoria.")
    public void remover(@PathVariable(value = "id", required = true) String id) {
        categoriaService.remover(id);
    }
}
