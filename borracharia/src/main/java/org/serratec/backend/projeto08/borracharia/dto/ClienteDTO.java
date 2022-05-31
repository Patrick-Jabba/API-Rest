package org.serratec.backend.projeto08.borracharia.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idCliente;

	private String nomeCliente;

	private String cpf;

	private String numeroTelefone;

	private String email;
	
	public ClienteDTO() {}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
