package org.serratec.java2backend.projeto03.controller;

import java.util.List;

import org.serratec.java2backend.projeto03.model.Todo;
import org.serratec.java2backend.projeto03.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/lista")
	public List<Todo> getTodo() {
		return todoService.listaTodo();
	}

	@PostMapping("/adicionar")
	public void adicionar(@RequestBody Todo todo) {
		todoService.adicionar(todo);
	}

	@PutMapping("/atualizar/{idTodo}")
	public void atualizar(@PathVariable Integer posicaoLista, @RequestBody Todo todo) {
		todoService.atualizar(posicaoLista, todo);
	}

	@DeleteMapping("/delete/{posicaoLista}")
	public void deletar(@PathVariable int posicaoLista) {
		todoService.deletar(posicaoLista);

	}
}
