package com.pazzini.memems.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pazzini.memems.config.Groups;
import com.pazzini.memems.dto.MemeDto;
import com.pazzini.memems.model.Meme;
import com.pazzini.memems.repository.IMemeRepository;
import com.pazzini.memems.service.MemeService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controlador responsável por lidar com as requisições relacionadas aos memes.
 */
@RestController
@RequestMapping("memes")
public class MemeController {

    @Autowired
    private MemeService memeService;
    @Autowired
    private IMemeRepository memeRepository;

    /**
     * Endpoint para listar todos os memes.
     *
     * @return Uma resposta com a lista de memes e o status OK.
     */
    @GetMapping
    @Operation(summary = "Busca uma página memes")
    public ResponseEntity<List<Meme>> listar() {
        return ResponseEntity.status(OK).body(memeRepository.findAll());
    }

    /**
     * Endpoint para buscar um meme por ID.
     *
     * @param id O ID do meme a ser buscado.
     * @return O meme encontrado e o status OK.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Busca um meme por ID")
    public Meme buscarPorId(@PathVariable String id) {
        return memeService.obterMeme(id);
    }

    /**
     * Endpoint para buscar o meme do dia de forma aleatória.
     *
     * @return O meme do dia aleatório e o status OK.
     */
    @GetMapping("/meme-do-dia")
    @Operation(summary = "Busca o meme do dia de forma aleatória")
    public Meme buscarAleatoria() {
        return memeService.aleatorio();
    }

    /**
     * Endpoint para cadastrar um novo meme.
     *
     * @param memeDto O DTO do meme a ser cadastrado.
     * @return A resposta com o meme cadastrado e o status CREATED.
     */
    @PostMapping
    @Operation(summary = "Cadastra um meme")
    public ResponseEntity<Object> cadastrar(
            @RequestBody @Validated(value = Groups.CadastroMeme.class) MemeDto memeDto) {
        return ResponseEntity.status(CREATED)
                .body(memeService.cadastrar(memeDto));
    }

    /**
     * Endpoint para atualizar um meme existente.
     *
     * @param id      O ID do meme a ser atualizado.
     * @param memeDto O DTO do meme com as informações atualizadas.
     * @return O meme atualizado e o status OK.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um meme")
    public Meme atualizar(@PathVariable String id,
                          @RequestBody @Valid MemeDto memeDto) {

        Meme memeAtual = memeService.obterMeme(id);

        BeanUtils.copyProperties(memeDto, memeAtual, "id", "usuario", "categoria");
        memeAtual.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));

        return memeService.atualizar(memeAtual);
    }

    /**
     * Endpoint para remover um meme pelo ID.
     *
     * @param id O ID do meme a ser removido.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove um meme")
    public void deletar(@PathVariable String id) {
        memeService.remover(id);
    }
}
