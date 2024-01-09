package com.pazzini.categoriaMemeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pazzini.categoriaMemeService.model.CategoriaMeme;

/**
 * Interface que estende a interface MongoRepository, fornecendo métodos padrão para operações de CRUD no MongoDB
 * relacionadas à entidade CategoriaMeme.
 */
public interface ICategoriaRepository extends MongoRepository<CategoriaMeme, String> {

}
