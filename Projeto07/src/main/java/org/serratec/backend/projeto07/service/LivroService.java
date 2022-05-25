package org.serratec.backend.projeto07.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto07.model.LivroModel;
import org.serratec.backend.projeto07.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	public List<LivroModel> listarLivros() {
		return livroRepository.findAll();
	}

	public LivroModel getLivroById(Long idLivro) {
		Optional<LivroModel> livroVazio = livroRepository.findById(idLivro);

		if (livroVazio.isEmpty()) {
			return null;
		}
		return livroVazio.get();
	}

	public List<LivroModel> listarLivrosOrdenados(String operacao) {

		if (operacao.equalsIgnoreCase("por-titulo")) {
			return livroRepository.findAllByOrderByTituloAsc();

		}
		if (operacao.equalsIgnoreCase("por-titulo-desc")) {
			return livroRepository.findAllByOrderByTituloDesc();

		}
		if (operacao.equalsIgnoreCase("por-id-desc")) {
			return livroRepository.findAllByOrderByIdLivroDesc();
		} else {
			return livroRepository.findAll();

		}
	}

	public void createLivro(LivroModel livroModel) {
		livroRepository.save(livroModel);
	}

	public void updateLivro(Long idLivro, LivroModel livroModel) {
		LivroModel livroUpdated = getLivroById(idLivro);

		if (livroModel.getAutor() != null) {
			livroUpdated.setAutor(livroModel.getAutor());
		}

		if (livroModel.getTitulo() != null) {
			livroUpdated.setTitulo(livroModel.getTitulo());
		}

		if (livroModel.getGenero() != null) {
			livroUpdated.setGenero(livroModel.getGenero());
		}

		if (livroModel.getDataPublicacao() != null) {
			livroUpdated.setDataPublicacao(livroModel.getDataPublicacao());
		}

		livroRepository.save(livroUpdated);
	}

	public void delete(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}

}
