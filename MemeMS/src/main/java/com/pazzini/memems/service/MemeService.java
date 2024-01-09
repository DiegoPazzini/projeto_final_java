package com.pazzini.memems.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.pazzini.memems.dto.MemeDto;
import com.pazzini.memems.exceptions.EntidadeNaoEncontradaException;
import com.pazzini.memems.exceptions.FeignException;
import com.pazzini.memems.feign.CategoriaFeignClient;
import com.pazzini.memems.feign.UsuarioFeignClient;
import com.pazzini.memems.model.CategoriaMeme;
import com.pazzini.memems.model.Meme;
import com.pazzini.memems.model.Usuario;
import com.pazzini.memems.repository.IMemeRepository;

@Service
@EnableMongoRepositories(basePackageClasses = IMemeRepository.class)
public class MemeService {

    // Mensagens de erro
	private static final String MSG_MEME_NOT_FOUND = "Não existe um cadastro de meme para o ID: %s";
	private static final String MSG_CATEGORIAFEIGN_NOT_FOUND = "Não foi possível encontrar a categoria com o id: %s na chamada à API externa";
	private static final String MSG_USUARIOFEIGN_NOT_FOUND = "Não foi possível encontrar o usuário com o id: %s na chamada à API externa";
	
	@Autowired
	private IMemeRepository memeRepository;	
	@Autowired
	private UsuarioFeignClient usuarioFeign;
	@Autowired
	private CategoriaFeignClient categoriaFeign;	
	
	public Meme cadastrar(MemeDto memeDto) {
		// Obtém o usuário e categoria usando Feign Clients
		Usuario usuario = getUsuarioFeign(memeDto);
		CategoriaMeme categoria = getCategoriaFeign(memeDto);
		
		// Cria um novo meme com base nos dados do DTO
		var meme = new Meme();
		BeanUtils.copyProperties(memeDto, meme);
		
		// Define a data de cadastro e associa o usuário e a categoria ao meme
		meme.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
		meme.setUsuario(usuario);
		meme.setCategoria(categoria);

		// Insere o meme no repositório
		return memeRepository.insert(meme);
	}
	
	public Meme atualizar(Meme meme) {
		// Atualiza o meme no repositório
		return memeRepository.save(meme);
	}
	
	public void remover(String id) {
		// Obtém o meme e o remove do repositório
		Meme meme = obterMeme(id);		
		memeRepository.delete(meme);
	}
	
	public Meme aleatorio() {
		// Obtém uma lista de memes e retorna um meme aleatório
		List<Meme> memes = memeRepository.findAll();
		
		if (memes.isEmpty()) {
			throw new RuntimeException("Não há memes cadastrados");
		}

		return memes.get(new Random().nextInt(memes.size()));
	}

	private CategoriaMeme getCategoriaFeign(MemeDto memeDto) {
		// Obtém a categoria usando o Feign Client
		String id = memeDto.getCategoria().getId();
		try {
			CategoriaMeme categoria = categoriaFeign.buscarPorId(id);
			return categoria;
		} catch (Exception e) {
			throw new FeignException(String.format(MSG_CATEGORIAFEIGN_NOT_FOUND, id));
		}
	}

	private Usuario getUsuarioFeign(MemeDto memeDto) {
		// Obtém o usuário usando o Feign Client
		String id = memeDto.getUsuario().getId();
		try {
			Usuario usuario = usuarioFeign.buscaPorId(id).getBody();
			return usuario;
		} catch (Exception e) {
			throw new FeignException(String.format(MSG_USUARIOFEIGN_NOT_FOUND, id));
		}
	}

	public Meme obterMeme(String id) {
		// Obtém o meme pelo ID ou lança uma exceção se não encontrado
		return memeRepository.findById(id)
		        .orElseThrow(() -> new EntidadeNaoEncontradaException(
		        		String.format(MSG_MEME_NOT_FOUND, id)));
	}
}
