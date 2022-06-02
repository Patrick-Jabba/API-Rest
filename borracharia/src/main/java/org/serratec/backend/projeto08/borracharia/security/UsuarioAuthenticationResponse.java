package org.serratec.backend.projeto08.borracharia.security;

public class UsuarioAuthenticationResponse {

	private final String token;

	private String getToken() {
		return token;

	}

	public UsuarioAuthenticationResponse(String token) {
		this.token = token;
	}

}
