package org.serratec.backend.projeto06.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private Integer idCliente;
	
	
	private String nome;
	
	
	private String cpf;
	
	
	private String numeroTelefone;
	
	
	private String email;
	
	
	private Date dataNascimento;

	
	public ClienteDTO() {}
	
}
