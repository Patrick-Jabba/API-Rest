package org.serratec.backend.projeto08.borracharia.model;

import java.io.Serializable;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carro")
public class CarroModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_cd_carro")
	private Integer idCarro;

	@NotNull
	@Column(name = "carro_tx_modelo")
	private String modelo;

	@NotNull
	@Column(name = "carro_tx_marca")
	private String marca;

	@NotNull
	@Column(name = "carro_num_ano")
	private Integer ano;

	@ManyToOne
	@JoinColumn(name = "cd_carro_cliente", referencedColumnName = "cliente_cd_cliente")
	private ClienteModel cliente;

//	@OneToMany(mappedBy = "carro")
//	private List<Servico> serviços;
	
	public CarroModel() {}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
