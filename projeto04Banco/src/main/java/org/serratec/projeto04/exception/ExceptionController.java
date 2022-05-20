package org.serratec.projeto04.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(OperacaoException.class)
	public ResponseEntity<String> trataOperacaoBadRequest(OperacaoException exception){
		String msgException = String.format("Saldo insuficiente para a operação", exception);
		return ResponseEntity.notFound()
				.header("x-erro-msg", msgException)
				.header("x-erro-code", "BAD REQUEST")
				.build();
	}
	
}
