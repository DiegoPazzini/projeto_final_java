package com.pazzini.memems.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pazzini.memems.model.Meme;

/**
 * Interface responsável pela comunicação com o banco de dados MongoDB para a entidade Meme.
 * Utiliza o framework Spring Data MongoDB.
 */
public interface IMemeRepository extends MongoRepository<Meme, String> {

    // Métodos específicos para operações com o Meme podem ser adicionados aqui, mas normalmente
    // são suficientes os métodos herdados da interface MongoRepository.
    
}
