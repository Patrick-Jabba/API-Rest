package serratec.monitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import serratec.monitoria.exception.CustomException;
import serratec.monitoria.model.Pessoa;
import serratec.monitoria.service.PessoaService;

@RestController
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok(pessoaService.findAll());
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) throws CustomException{
		return ResponseEntity.ok(pessoaService.findById(id));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
		return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable Long id) throws CustomException{
		return new ResponseEntity<>(pessoaService.update(pessoa, id), HttpStatus.ACCEPTED);
	}
	
}