package org.serratec.backend.projeto08.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.projeto08.borracharia.dto.CarroDTO;
import org.serratec.backend.projeto08.borracharia.exception.CarroException;
import org.serratec.backend.projeto08.borracharia.services.CarroService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String salvar(@RequestBody CarroDTO carroDTO) throws MessagingException{
		return carroService.salvar(carroDTO);
		
	}
	
	@GetMapping("/{idCarro}")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException{
		return ResponseEntity.ok(carroService.findById(idCarro));
	}
	
	@GetMapping
	public ResponseEntity<List<CarroDTO>> listarTodos(){
		return ResponseEntity.ok(carroService.listarTodos());
	}
	
	@PutMapping("/{idCarro}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String atualizar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO){
		return carroService.atualizar(idCarro, carroDTO);
	}
	
	@DeleteMapping("/{idCarro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idCarro) {
		carroService.deletar(idCarro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
