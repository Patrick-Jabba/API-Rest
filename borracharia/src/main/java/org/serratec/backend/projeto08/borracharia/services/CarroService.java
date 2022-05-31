package org.serratec.backend.projeto08.borracharia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.projeto08.borracharia.dto.CarroDTO;
import org.serratec.backend.projeto08.borracharia.exception.CarroException;
import org.serratec.backend.projeto08.borracharia.model.CarroModel;
import org.serratec.backend.projeto08.borracharia.repository.CarroRepository;
import org.serratec.backend.projeto08.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public CarroDTO toDTO(CarroDTO carroDTO, CarroModel carro) {
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAno(carro.getAno());

		if (carro.getCliente() != null) {
			carroDTO.setIdCliente(carro.getCliente().getIdCliente());
			carroDTO.setNomeCliente(carro.getCliente().getNomeCliente());
		}
		return carroDTO;
	}

	public CarroModel toModel(CarroDTO carroDTO, CarroModel carro) {
		// nao setamos o ID pois é auto_increment
		carro.setModelo(carroDTO.getModelo());
		carro.setMarca(carroDTO.getMarca());
		carro.setAno(carroDTO.getAno());

		if (carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}
		return carro;
	}

	public String salvar(CarroDTO carroDTO) throws MessagingException {
		CarroModel carro = new CarroModel();
		CarroModel carroSalvar = toModel(carroDTO, carro);
		carroRepository.save(carroSalvar);
		return "O carro foi cadastrado com o id " + carro.getIdCarro();
	}

	public CarroDTO findById(Integer idCarro) throws CarroException {
		Optional<CarroModel> carroModel = carroRepository.findById(idCarro);

		CarroModel carroNoBanco = new CarroModel();
		CarroDTO carroDTO = new CarroDTO();

		if (carroModel.isPresent()) {
			carroNoBanco = carroModel.get();
			toDTO(carroDTO, carroNoBanco);
			return carroDTO;
		}
		throw new CarroException("Carro com o id buscado não encontrado.");
	}

	public List<CarroDTO> listarTodos() {
		List<CarroModel> listacarro = carroRepository.findAll();
		List<CarroDTO> listacarroDTO = new ArrayList<>();

		for (CarroModel carro : listacarro) {
			CarroDTO carroDTO = new CarroDTO();
			toDTO(carroDTO, carro);
			listacarroDTO.add(carroDTO);
		}
		return listacarroDTO;
	}
	
	public String atualizar(Integer idCarro, CarroDTO carroDTO) {
		Optional<CarroModel> carro = carroRepository.findById(idCarro);
		CarroModel carroNoBanco = new CarroModel();
		
		if(carro.isPresent()) {
			carroNoBanco = carro.get();
			if(carroDTO.getModelo() != null) {
				carroNoBanco.setModelo(carroDTO.getModelo());
			}
			if(carroDTO.getMarca() != null) {
				carroNoBanco.setMarca(carroDTO.getMarca());
			}
			if(carroDTO.getAno() != null) {
				carroNoBanco.setAno(carroDTO.getAno());
			}
			if(carroDTO.getIdCliente() != null) {
				carroNoBanco.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
			}
			carroRepository.save(carroNoBanco);
		} 
		return "O cadastro do carro com o id " + carroNoBanco.getIdCarro() + " foi atualizado com sucesso";
	
	}
	
	public void deletar(Integer idCarro) {
		carroRepository.deleteById(idCarro);
		}
	
	
}
