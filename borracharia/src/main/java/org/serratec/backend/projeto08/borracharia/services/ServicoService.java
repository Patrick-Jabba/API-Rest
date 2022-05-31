package org.serratec.backend.projeto08.borracharia.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.serratec.backend.projeto08.borracharia.dto.RelatorioServicoDTO;
import org.serratec.backend.projeto08.borracharia.dto.ServicoDTO;

import org.serratec.backend.projeto08.borracharia.exception.ServicoException;
import org.serratec.backend.projeto08.borracharia.model.CarroModel;
import org.serratec.backend.projeto08.borracharia.model.Servico;
import org.serratec.backend.projeto08.borracharia.repository.CarroRepository;
import org.serratec.backend.projeto08.borracharia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class ServicoService {

	@Autowired
	CarroRepository carroRepository;

	@Autowired
	ServicoRepository servicoRepository;

	@Autowired
	EmailService emailService;

	public ServicoDTO toDTO(ServicoDTO servicoDTO, Servico servico) {
		servico.getData();
		servicoDTO.setData(LocalDate.now());
		servicoDTO.setValor(servico.getValor());
		servicoDTO.setStatus(servico.getStatus());
		servicoDTO.setIdServico(servico.getIdServico());
		servicoDTO.setServicoPrestado(servico.getServicoPrestado());
		if (servico.getCarro() != null) {
			servicoDTO.setIdCarro(servico.getCarro().getIdCarro());
			servicoDTO.setNomeCliente(servico.getCarro().getCliente().getNomeCliente());
		}
		return servicoDTO;
	}

	public Servico toModel(ServicoDTO servicoDTO, Servico servico) throws ServicoException {
		// nao setamos o ID pois é auto_increment

		Optional<CarroModel> carro = carroRepository.findById(servicoDTO.getIdCarro());

		if (carro.isEmpty()) {
			throw new ServicoException("Não foi possível cadastrar, tente novamente");
		}
		servico.setCarro(carro.get());
		servico.setValor(servicoDTO.getValor());
		servico.setServicoPrestado(servicoDTO.getServicoPrestado());
		servico.setData(servicoDTO.getData());
		servico.setStatus(servicoDTO.getStatus());

		return servico;
	}

	public RelatorioServicoDTO fromModelToRelatorioDto(Servico model) {

		RelatorioServicoDTO dto = new RelatorioServicoDTO();

		dto.setModeloCarro(model.getCarro().getModelo());
		dto.setNomeCliente(model.getCarro().getCliente().getNomeCliente());
		dto.setServicoPrestado(model.getServicoPrestado());
		dto.setValor(model.getValor());

		return dto;
	}

	public List<RelatorioServicoDTO> fromModelToRelatorioDto(List<Servico> models) {

		List<RelatorioServicoDTO> dtos = new ArrayList<>();

		for (Servico model : models) {

			dtos.add(fromModelToRelatorioDto(model));
		}

		return dtos;
	}

	public String registrar(ServicoDTO servicoDTO) throws ServicoException {
		Servico servico = new Servico();

		servico = toModel(servicoDTO, servico);
		servicoRepository.save(servico);

		return "O servico foi registrado com sucesso sob o identificador de número : " + servico.getIdServico();

	}

	public ServicoDTO findById(Integer idServico) throws ServicoException {
		Optional<Servico> servico = servicoRepository.findById(idServico);

		Servico servicoNoBanco = new Servico();
		ServicoDTO servicoDTO = new ServicoDTO();

		if (servico.isPresent()) {
			servicoNoBanco = servico.get();
			toDTO(servicoDTO, servicoNoBanco);
			return servicoDTO;
		}
		throw new ServicoException("O serviço com o id buscado não foi encontrado!");
	}

	public List<ServicoDTO> findAll() {
		List<Servico> listaServicoModel = servicoRepository.findAll();
		List<ServicoDTO> listaServicoDTO = new ArrayList<>();

		for (Servico servico : listaServicoModel) {
			ServicoDTO servicoDTO = new ServicoDTO();
			toDTO(servicoDTO, servico);
			listaServicoDTO.add(servicoDTO);
		}
		return listaServicoDTO;

	}

	public String atualizar(Integer idServico, ServicoDTO servicoDTO) throws Exception {
		Optional<Servico> servico = servicoRepository.findById(idServico);

		Servico servicoSalvar = new Servico();
		if (servico.isPresent()) {
			servicoSalvar = servico.get();

			if (servicoDTO.getValor() != null) {
				servicoSalvar.setValor(servicoDTO.getValor());
			}
			if (servicoDTO.getStatus() != null) {
				servicoSalvar.setStatus(servicoDTO.getStatus());
			}
			if (servicoDTO.getData() != null) {
				servicoSalvar.setData(servicoDTO.getData());
			}
			if (servicoDTO.getServicoPrestado() != null) {
				servicoSalvar.setServicoPrestado(servicoDTO.getServicoPrestado());
			}

			if (servicoDTO.getIdCarro() != null) {
				servicoSalvar.setCarro(carroRepository.findById(servicoDTO.getIdCarro()).get());
			}

			servicoRepository.save(servicoSalvar);
			emailService.emailTeste(servicoDTO);

			return "O status do serviço com o id " + servico.get().getIdServico() + " foi atualizado com sucesso";
		}

		return "Não foi possível atualizar!";

	}

//	public void finalizar(Integer idServico) {
//		Optional<Servico> servico = servicoRepository.findById(idServico);
//		
//		if(servico.isPresent()) {
//			}
//	}

	public void deletar(Integer idServico) {
		servicoRepository.deleteById(idServico);
	}

	public List<Servico> getRelatorio(int tamanhoRelatorio) {
		List<Servico> allServicos = servicoRepository.findAllByOrderByIdServicoDesc();
		List<Servico> relatorio = new ArrayList<Servico>();

		if (tamanhoRelatorio >= allServicos.size()) {
			return allServicos;
		} else {
			for (int i = 0; i < tamanhoRelatorio; i++) {

				relatorio.add(allServicos.get(i));
			}
			return relatorio;
		}
	}
}
