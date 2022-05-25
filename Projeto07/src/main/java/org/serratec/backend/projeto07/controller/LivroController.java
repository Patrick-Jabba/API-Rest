package org.serratec.backend.projeto07.controller;

import java.util.List;

import org.serratec.backend.projeto07.dto.LivroDTO;
import org.serratec.backend.projeto07.mapper.LivroMapper;
import org.serratec.backend.projeto07.model.LivroModel;
import org.serratec.backend.projeto07.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService livroService;
	
	@Autowired
	LivroMapper livroMapper;
	
	@GetMapping
	public ResponseEntity<List<LivroModel>> listarLivros(){
		return ResponseEntity.ok(livroService.listarLivros());
	}
	
	@GetMapping("/{idLivro}")
	public ResponseEntity<LivroDTO> getLivroById(@PathVariable Long idLivro){
		
		LivroModel livroModel = livroService.getLivroById(idLivro);
		
		return ResponseEntity.ok(livroMapper.toDTO(livroModel));
	}
	
	@GetMapping("/lista-ordenada")
	public ResponseEntity<List<LivroModel>> listarLivrosOrdenados(
			@RequestParam String operacao){
		return ResponseEntity.ok(livroService.listarLivrosOrdenados(operacao));
	}
	
//	@GetMapping("/desc")
//	public ResponseEntity<List<LivroModel>> listarLivrosOrdenadosDesc(){
//		return ResponseEntity.ok(livroService.listarLivrosOrdenadosDesc());
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createLivro(@RequestBody LivroDTO livroDTO){
		livroService.createLivro(livroMapper.toModel(livroDTO));
	}
	
	@PutMapping("/{idLivro}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateLivro(@PathVariable Long idLivro, @RequestBody LivroDTO livroModel) {
		livroService.updateLivro(idLivro, livroMapper.toModel(livroModel));
	}
	
	@DeleteMapping("/{idLivro}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable Long idLivro) {
		livroService.delete(idLivro);
	}
	
	
}
