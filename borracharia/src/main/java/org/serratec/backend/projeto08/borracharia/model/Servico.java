package org.serratec.backend.projeto08.borracharia.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.serratec.backend.projeto08.borracharia.dto.ServicoDTO;
import org.serratec.backend.projeto08.borracharia.exception.ServicoException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "servico")
public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_cd_servico")
	private Integer idServico;

	@NotNull
	@Column(name = "servico_num_valor")
	private Double valor;

	@NotNull
	@Column(name = "servico_tx_servico_prestado")
	private String servicoPrestado;

	@NotNull
	@Column(name = "servico_data")
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private StatusServico status;

	@ManyToOne
	@JoinColumn(name = "carro_cliente", referencedColumnName = "carro_cd_carro")
	private CarroModel carro;

	public Servico() {
	}

	
	public void finalizar() throws ServicoException {
		if (naoPodeSerFinalizada()) {
			throw new ServicoException("Entrega não pode ser finalizada.");
		}

		setStatus(StatusServico.FINALIZADO);
		setData(LocalDate.now());
	}

	public boolean podeSerFinalizada() {
		return StatusServico.PENDENTE.equals(getStatus());
	}

	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
	
	public void registrar(Servico servico, CarroModel carroModel) {
		this.status = servico.getStatus();
		this.data = LocalDate.now();
		this.valor = servico.getValor();
		this.idServico = servico.getIdServico();
		this.servicoPrestado = servico.getServicoPrestado();
		this.carro = carroModel;
	}
	
	public void atualizar(ServicoDTO servicoDTO, CarroModel carroModel) {
		this.status = servicoDTO.getStatus();
		this.data = LocalDate.now();
		this.valor = servicoDTO.getValor();
		this.servicoPrestado = servicoDTO.getServicoPrestado();
		this.carro = carroModel;
	}

}
