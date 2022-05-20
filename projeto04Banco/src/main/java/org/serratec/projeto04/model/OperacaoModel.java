package org.serratec.projeto04.model;

public class OperacaoModel {

	private String tipo;
	private Double saldo;
	
	public OperacaoModel() {}
	
	public OperacaoModel(String tipo, Double saldo) {
		super();
		this.tipo = tipo;
		this.saldo = saldo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	

	
}
