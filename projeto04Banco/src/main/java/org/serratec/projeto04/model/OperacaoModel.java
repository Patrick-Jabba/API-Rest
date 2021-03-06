package org.serratec.projeto04.model;

public class OperacaoModel {

	private Tipo tipo;
	private Double valor;

	public OperacaoModel() {
	}

	public OperacaoModel(Tipo tipo, Double valor) {
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
