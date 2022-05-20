package org.serratec.java2backend.projeto03.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(TodoException.class)
	public ResponseEntity<String> trataTodoNotFound(TodoException exception){
		String msgException = String.format("O todo com o ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msgException)
				.header("x-erro-code", "TODO NOT FOUND")
				.header("x-erro-msg", exception.getId().toString())
				.build();
	}
}
