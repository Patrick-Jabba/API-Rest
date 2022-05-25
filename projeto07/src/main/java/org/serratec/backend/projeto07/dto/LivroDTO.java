package org.serratec.backend.projeto07.dto;

import java.time.LocalDate;

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
	
	private LocalDate dataPublicacao;
	
	public LivroDTO() {}
}
