package com.pazzini.categoriaMemeService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pazzini.categoriaMemeService.model.Usuario;

/**
 * Interface que define um cliente Feign para interagir com o serviço de usuários.
 */
@FeignClient(name = "usuario-service", url = "localhost:8000")
public interface UsuarioFeignClient {

    /**
     * Método que utiliza a anotação @GetMapping para especificar uma requisição GET para buscar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return Um objeto do tipo {@link Usuario} representando o usuário encontrado.
     */
    @GetMapping("usuarios/{id}")
    Usuario buscaPorId(@PathVariable String id);
}
