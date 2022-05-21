package org.serratec.backend.projeto04versao2.controller;

import java.util.List;

import org.serratec.backend.projeto04versao2.exception.CustomException;
import org.serratec.backend.projeto04versao2.model.ContaModel;
import org.serratec.backend.projeto04versao2.service.ContaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ContaModel>> findAll(){
		return ResponseEntity.ok(contaService.findAll());
	}
	
	@GetMapping("/buscar/{idConta}")
	public ResponseEntity<ContaModel> findById(@PathVariable Integer idConta){
		return ResponseEntity.ok(contaService.findById(idConta));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> create(@RequestBody ContaModel conta){
		contaService.create(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/adicionarVariasContas")
	public ResponseEntity<Void> createAllAccounts(@RequestBody List<ContaModel> conta){
		contaService.createAllAccounts(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/atualizar/{idConta}")
	public ResponseEntity<Void> update(@PathVariable Integer idConta, @RequestBody ContaModel conta){
		contaService.update(idConta, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{idConta}/transfere")
	public ResponseEntity<Void> transfere(
			@PathVariable Integer idConta,
			@RequestParam String operacao,
			@RequestParam Double valorParametro) throws CustomException{
		contaService.transfere(idConta, operacao, valorParametro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletar/{idConta}")
	public ResponseEntity<Void> delete(@PathVariable Integer idConta){
		contaService.delete(idConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	
}
