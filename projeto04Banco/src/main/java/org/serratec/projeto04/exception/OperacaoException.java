package org.serratec.projeto04.exception;

import org.serratec.projeto04.model.Tipo;

public class OperacaoException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private Tipo tipo;
	private Double valor;

	public OperacaoException() {
	}

	public OperacaoException(Tipo tipo, Double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
