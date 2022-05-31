package org.serratec.backend.projeto08.borracharia.controller;

import java.util.List;


import javax.validation.Valid;

import org.serratec.backend.projeto08.borracharia.dto.RelatorioServicoDTO;
import org.serratec.backend.projeto08.borracharia.dto.ServicoDTO;
import org.serratec.backend.projeto08.borracharia.exception.ServicoException;
import org.serratec.backend.projeto08.borracharia.model.Servico;
import org.serratec.backend.projeto08.borracharia.repository.CarroRepository;
import org.serratec.backend.projeto08.borracharia.services.CarroService;
import org.serratec.backend.projeto08.borracharia.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;

	@Autowired
	CarroRepository carroRepository;

	@Autowired
	CarroService carroSerivce;

	@PostMapping
	public ResponseEntity<String> registrar(@RequestBody ServicoDTO servicoDTO) throws ServicoException {
		return ResponseEntity.ok(servicoService.registrar(servicoDTO));
	}

	@GetMapping
	public ResponseEntity<List<ServicoDTO>> findAll() {
		return ResponseEntity.ok(servicoService.findAll());

	}

	@Transactional 
	@PutMapping("/{idServico}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idServico, @Valid @RequestBody ServicoDTO servicoDTO) throws Exception {
		return ResponseEntity.ok(servicoService.atualizar(idServico, servicoDTO));
	}

	@DeleteMapping("/{idServico}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idServico) {
		servicoService.deletar(idServico);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/relatorio/{tamanhoRelatorio}")
    public ResponseEntity<List<RelatorioServicoDTO>> getRelatorio(@PathVariable int tamanhoRelatorio) {
		List<Servico> servico = servicoService.getRelatorio(tamanhoRelatorio);
		
		
        return ResponseEntity.ok(servicoService.fromModelToRelatorioDto(servico));

    }

}
