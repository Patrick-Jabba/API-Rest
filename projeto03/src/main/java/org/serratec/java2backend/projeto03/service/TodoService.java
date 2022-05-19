package org.serratec.java2backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto03.model.Todo;
//import org.serratec.java2backend.projeto03.repository.TodoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
//	@Autowired
//	TodoRepository todoRepository;
	
	List<Todo> lista = new ArrayList<>();
	
	public void adicionar(Todo todo) {
		lista.add(todo);
	}
	
	
	public List<Todo> listaTodo(){
		return this.lista;
	}
	
	public void atualizar(Integer posicaoLista, Todo todoDaApi) {
		//idtodo é posição na lista/array
		Todo todoDaListaSalva = new Todo();
		todoDaListaSalva = lista.get(posicaoLista);
		
		todoDaListaSalva.setId(todoDaApi.getId());
		todoDaListaSalva.setDescription(todoDaApi.getDescription());
		todoDaListaSalva.setTitle(todoDaApi.getTitle());
		
		
	}
	
	public void deletar (int posicaoLista) {
		lista.remove(posicaoLista);
	}
	
	
//	public Todo findById(Integer idTodo) {
//		//confirma 
//		Optional<Todo> todo = todoRepository.findById(idTodo);
//		
//		Todo todoNoBanco = new Todo();
//		
//		if (todo.isPresent())
//			todoNoBanco = todo.get();
//		
//		return todoNoBanco;
//	}
	
	
}
