package com.pazzini.memems.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pazzini.memems.model.Usuario;

/**
 * Interface Feign Client para realizar chamadas ao serviço de Usuário.
 */
@Component
@FeignClient(name = "usuario-service", url = "localhost:8000")
public interface UsuarioFeignClient {

    /**
     * Método para buscar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return A resposta contendo o usuário encontrado.
     */
    @GetMapping("usuarios/{id}")
    ResponseEntity<Usuario> buscaPorId(@PathVariable String id);

}
