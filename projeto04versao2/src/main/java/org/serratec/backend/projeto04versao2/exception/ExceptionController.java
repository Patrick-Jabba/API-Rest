package org.serratec.backend.projeto04versao2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> trataOperacaoBadRequest(CustomException exception){
		String msgException = String.format("Saldo insuficiente para a operação", exception);
		return ResponseEntity.notFound()
				.header("x-erro-msg", msgException)
				.header("x-erro-code", "BAD REQUEST")
				.build();
	}
	
}
