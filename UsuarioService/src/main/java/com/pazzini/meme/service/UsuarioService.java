package com.pazzini.meme.service;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.pazzini.meme.exceptions.EntidadeNaoEncontradaException;
import com.pazzini.meme.model.Usuario;
import com.pazzini.meme.repository.IUsuarioRepository;

/**
 * Serviço que fornece métodos para manipulação de dados relacionados à entidade Usuario.
 */
@EnableMongoRepositories(basePackageClasses = IUsuarioRepository.class)
@Service
public class UsuarioService {

    private static final String MSG_USUARIO_NOT_FOUND = "Não existe um cadastro de usuario para o ID: %s";
    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Cadastra um novo usuário no banco de dados.
     *
     * @param usuario O usuário a ser cadastrado.
     * @return O usuário cadastrado.
     */
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.insert(usuario);
    }

    /**
     * Atualiza as informações de um usuário no banco de dados.
     *
     * @param usuario O usuário com as informações atualizadas.
     * @return O usuário atualizado.
     */
    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Remove um usuário do banco de dados com base no ID.
     *
     * @param id O ID do usuário a ser removido.
     */
    public void removerUsuario(String id) {
        Usuario usuario = obterUsuario(id);
        usuarioRepository.delete(usuario);
    }

    /**
     * Verifica se já existe um usuário cadastrado com o e-mail fornecido.
     *
     * @param email O e-mail a ser verificado.
     * @return true se o e-mail já estiver em uso, false caso contrário.
     */
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    /**
     * Obtém um usuário do banco de dados com base no ID.
     *
     * @param id O ID do usuário a ser obtido.
     * @return O usuário correspondente ao ID.
     * @throws EntidadeNaoEncontradaException Se nenhum usuário for encontrado com o ID fornecido.
     */
    public Usuario obterUsuario(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_USUARIO_NOT_FOUND, id)));
    }

}
