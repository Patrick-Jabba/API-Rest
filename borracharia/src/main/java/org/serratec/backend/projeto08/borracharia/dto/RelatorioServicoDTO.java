package org.serratec.backend.projeto08.borracharia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RelatorioServicoDTO {
	
	private String nomeCliente;
	
	private String modeloCarro;
	
	private Double valor;
	
	private String servicoPrestado;
	
	public RelatorioServicoDTO() {}
	
	
}
