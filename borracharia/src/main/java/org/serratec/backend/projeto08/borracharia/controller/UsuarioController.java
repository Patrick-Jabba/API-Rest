package org.serratec.backend.projeto08.borracharia.controller;

import org.serratec.backend.projeto08.borracharia.dto.UsuarioDTO;
import org.serratec.backend.projeto08.borracharia.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/buscarPorLogin")
	public ResponseEntity<UsuarioDTO> buscarPorLogin(String login){
		return ResponseEntity.ok(usuarioService.buscarPorLogin(login));
	}
	
	@GetMapping("/{idConta}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer idUsuario){
		return ResponseEntity.ok(usuarioService.buscar(idUsuario));
	}
	
	@PostMapping
	public ResponseEntity<Integer> salvar(@RequestBody UsuarioDTO udto){
		return ResponseEntity.ok(usuarioService.salvar(udto));
	}
	
	
	
}
