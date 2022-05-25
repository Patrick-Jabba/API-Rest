package org.serratec.backend.projeto07.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LivroDTO {

	private String titulo;
	
	private String genero;
	
	private String autor;
	
	private Date dataPublicacao;
	
	public LivroDTO() {}
}
