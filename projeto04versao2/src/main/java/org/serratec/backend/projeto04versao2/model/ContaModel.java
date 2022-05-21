package org.serratec.backend.projeto04versao2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conta")
public class ContaModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="conta_cd_id")
	private Integer idConta;
	
	@Column(name="conta_num_conta")
	private Integer numeroConta;
	
	@Column(name="conta_tx_titular")
	private String titular;
	
	@Column(name="conta_num_saldo")
	private Double saldo;
	
	public ContaModel() {}
	
	public ContaModel(Integer idConta, Integer numeroConta, String titular, Double saldo) {
		super();
		this.idConta = idConta;
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}	
	
}
