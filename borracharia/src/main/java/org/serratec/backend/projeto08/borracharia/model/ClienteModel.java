package org.serratec.backend.projeto08.borracharia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_cd_cliente")
	private Integer idCliente;

	@NotNull
	@Column(name = "cliente_tx_nome_cliente")
	private String nomeCliente;

	@NotNull
	@Column(name = "cliente_tx_cpf", unique = true)
	private String cpf;

	@Column(name = "cliente_tx_numero_telefone")
	private String numeroTelefone;

	@NotNull
	@Email
	@Column(name = "cliente_tx_email", unique = true)
	private String email;

	@OneToMany(mappedBy = "cliente")
	@Column(name = "cliente_lista_carro")
	private List<CarroModel> carros;
	
	public ClienteModel() {}

}
