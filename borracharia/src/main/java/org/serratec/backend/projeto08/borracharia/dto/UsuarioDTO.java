package org.serratec.backend.projeto08.borracharia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

	private Integer idUsuario;
	
	private String username;
	
	private String password;
	
	public UsuarioDTO() {}
}
