package org.serratec.projeto05.controller;


import java.util.List;

import org.serratec.projeto05.model.PetShopModel;
import org.serratec.projeto05.service.PetShopService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PetController {
	
	@Autowired
	PetShopService petShopService;

	@GetMapping("/listar")
	public List<PetShopModel> getPetShop(){
		return petShopService.listarLojas();
	}
	
	@GetMapping("/buscarPorId/{idLoja}")
	public ResponseEntity<PetShopModel> buscarPorId(@PathVariable Integer idLoja){
		return ResponseEntity.ok(petShopService.buscarPorId(idLoja));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody PetShopModel petShop){
		petShopService.adicionar(petShop);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//Busca pelo Id da Loja sem possibilidade de setar o ID
	@PutMapping("/atualizarPorId/{idLoja}")
	public ResponseEntity<Void> atualizarPorId(@PathVariable Integer idLoja, @RequestBody PetShopModel petShopDaApi){
		petShopService.atualizarPorId(idLoja, petShopDaApi);
		return new ResponseEntity<>(HttpStatus.ACCEPTED); 
	}
	
	//Busca pelo Indice da Lista
	@PutMapping("/atualizar/{posicaoIndiceLista}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer posicaoIndiceLista, @RequestBody PetShopModel petShop){
		petShopService.atualizar(posicaoIndiceLista, petShop);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletar/{posicaoLista}")
	public ResponseEntity<Void> deletar(@PathVariable int posicaoLista){
		petShopService.deletar(posicaoLista);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
}
