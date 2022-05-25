package org.serratec.backend.projeto07.mapper;

import org.serratec.backend.projeto07.dto.LivroDTO;
import org.serratec.backend.projeto07.model.LivroModel;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

	public LivroModel toModel(LivroDTO livroDTO) {
		LivroModel livro = new LivroModel();
		
		livro.setAutor(livroDTO.getAutor());
		livro.setTitulo(livroDTO.getTitulo());
		livro.setGenero(livroDTO.getGenero());
		livro.setDataPublicacao(livroDTO.getDataPublicacao());
		
		return livro;
	}
	
	public LivroDTO toDTO(LivroModel livroModel) {
		LivroDTO livroDTO = new LivroDTO();
		
		livroDTO.setAutor(livroModel.getAutor());
		livroDTO.setTitulo(livroModel.getTitulo());
		livroDTO.setGenero(livroModel.getGenero());
		livroDTO.setDataPublicacao(livroModel.getDataPublicacao());
		
		return livroDTO;
	}
		
}
