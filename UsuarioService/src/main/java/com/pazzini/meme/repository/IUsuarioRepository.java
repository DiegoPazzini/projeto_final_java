package com.pazzini.meme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pazzini.meme.model.Usuario;

/**
 * Interface do repositório que estende a interface MongoRepository para a entidade Usuario.
 * Oferece métodos para interação com o banco de dados MongoDB para operações relacionadas ao Usuario.
 */
@Repository
public interface IUsuarioRepository extends MongoRepository<Usuario, String> {

    /**
     * Verifica se um usuário com o e-mail fornecido já existe no banco de dados.
     *
     * @param email O e-mail a ser verificado.
     * @return true se o e-mail já estiver em uso, false caso contrário.
     */
    Boolean existsByEmail(String email);

}
