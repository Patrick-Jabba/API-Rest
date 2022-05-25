package org.serratec.java2backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto03.exception.TodoException;
import org.serratec.java2backend.projeto03.model.Todo;
import org.springframework.beans.factory.annotation.Value;
//import org.serratec.java2backend.projeto03.repository.TodoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Value("${url.serratec}")
	private String urlSerratec;

//	@Autowired
//	TodoRepository todoRepository;

	// Lista Todo
	List<Todo> lista = new ArrayList<>();

	// Busca a Lista inteira com GET
	public List<Todo> listaTodo() {
		return this.lista;
	}

	// Buscar por ID Get
	public Todo buscarPorId(Integer idTodo) throws TodoException {
		Todo todoNoBanco = new Todo();
		for (Todo todo : lista) {
			if (todo.getId().equals(idTodo)) {
				todoNoBanco = todo;
			}
		}
		if (todoNoBanco.getId() == null) {
			throw new TodoException(idTodo);
		}
		return todoNoBanco;

	}

	// Método ADICIONAR
	public void adicionar(Todo todo) {
		lista.add(todo);

	}

	public void atualizar(Integer posicaoLista, Todo todoDaApi) {
		// idtodo é posição na lista/array
		Todo todoDaListaSalva = new Todo();
		todoDaListaSalva = lista.get(posicaoLista);

		todoDaListaSalva.setId(todoDaApi.getId());
		todoDaListaSalva.setDescription(todoDaApi.getDescription());
		todoDaListaSalva.setTitle(todoDaApi.getTitle());

	}

	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}

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
