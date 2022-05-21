package org.serratec.backend.projeto04versao2.exception;

public class CustomException extends Exception {

private static final long serialVersionUID = 1L;
	
	public CustomException(String message) {
		super(message);
	}
	
	public CustomException() {}
}
