package org.serratec.backend.projeto08.borracharia.controller;

import java.util.List;

import org.serratec.backend.projeto08.borracharia.dto.ClienteDTO;
import org.serratec.backend.projeto08.borracharia.exception.ClienteException;
import org.serratec.backend.projeto08.borracharia.services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO) {
		clienteService.salvar(clienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listarTodos() {
		return ResponseEntity.ok(clienteService.listarTodos());
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException {
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
		 
	}
	
	@PutMapping("/{idCliente}")
	public ResponseEntity<Void> atualizarCliente(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO) {
		clienteService.atualizarCliente(idCliente, clienteDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{idCliente}")
		public ResponseEntity<Void> delete(@PathVariable Integer idCliente) {
			clienteService.delete(idCliente);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}

	
	
}
