package org.serratec.projeto04.controller;

import java.util.List;

import org.serratec.projeto04.exception.OperacaoException;
import org.serratec.projeto04.model.ContaModel;
import org.serratec.projeto04.service.ContaService;
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
public class APIController {

	@Autowired
	ContaService contaService;

	@GetMapping("/listar")
	public List<ContaModel> getConta() {
		return contaService.listarContas();
	}

	@GetMapping("/listar/{numeroConta}")
	public ResponseEntity<ContaModel> listarContasPorNumero(@PathVariable Integer numeroConta) {
		return ResponseEntity.ok(contaService.listarContasPorNumero(numeroConta));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Void> adicionar(@RequestBody ContaModel contaNova) {
		contaService.adicionar(contaNova);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizarConta/{numeroConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer numeroConta, @RequestBody ContaModel contaAtualizada){
		contaService.atualizar(numeroConta, contaAtualizada);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{numeroConta}/transfere")
	public ResponseEntity<Void> transfere(
			@PathVariable Integer numeroConta,
			@RequestParam String operacao,
			@RequestParam Double valorParametro) throws OperacaoException{
		contaService.transfere(numeroConta, operacao, valorParametro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletar/{numeroConta}")
	public ResponseEntity<Void> deletaConta(@PathVariable int numeroConta){
		contaService.deletar(numeroConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	

}
