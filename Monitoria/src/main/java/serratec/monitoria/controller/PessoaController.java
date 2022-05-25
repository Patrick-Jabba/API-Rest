package serratec.monitoria.controller;

import java.util.List;

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

import serratec.monitoria.dto.PessoaDTO;
import serratec.monitoria.exception.CustomException;
import serratec.monitoria.model.Pessoa;
import serratec.monitoria.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok(pessoaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) throws CustomException{
		return ResponseEntity.ok(pessoaService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
		return new ResponseEntity<>(pessoaService.create(pessoaDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@RequestBody PessoaDTO pessoa, @PathVariable Long id) throws CustomException{
		pessoaService.update(pessoa, id);
	}
	
//	@PatchMapping
//	public ResponseEntity<Pessoa> update2(@RequestBody Pessoa pessoa, @PathVariable Long id){
//		return new ResponseEntity<>(pessoaService.update2(pessoa, id), HttpStatus.ACCEPTED);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws CustomException{
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}