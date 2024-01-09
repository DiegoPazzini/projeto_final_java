package com.pazzini.memems.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pazzini.memems.model.CategoriaMeme;

/**
 * Interface Feign Client para realizar chamadas ao serviço Categoria Meme.
 */
@Component
@FeignClient(name = "categoria-meme-service", url = "localhost:8200")
public interface CategoriaFeignClient {

    /**
     * Método para buscar uma categoria de meme pelo ID.
     *
     * @param id O ID da categoria de meme a ser buscada.
     * @return A categoria de meme encontrada.
     */
    @GetMapping("categorias/{id}")
    CategoriaMeme buscarPorId(@PathVariable String id);

}
