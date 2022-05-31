package org.serratec.backend.projeto08.borracharia.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.serratec.backend.projeto08.borracharia.model.StatusServico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServicoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idServico;

	private Double valor;

	private String servicoPrestado;
	
	private LocalDate data;

	private StatusServico status;
	
	private Integer idCarro;
	
	private String NomeCliente;
	
	public ServicoDTO() {}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getIdCarro() {
		return idCarro;
	}
	
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
}
