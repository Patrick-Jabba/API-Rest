package org.serratec.backend.projeto08.borracharia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto08.borracharia.dto.ClienteDTO;
import org.serratec.backend.projeto08.borracharia.exception.ClienteException;
import org.serratec.backend.projeto08.borracharia.model.ClienteModel;
import org.serratec.backend.projeto08.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteDTO toDTO(ClienteDTO clienteDTO, ClienteModel cliente) {
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNomeCliente(cliente.getNomeCliente());

		return clienteDTO;
	}

	public ClienteModel toModel(ClienteDTO clienteDTO, ClienteModel cliente) {
		// nao setamos o ID pois é auto_increment

		cliente.setNomeCliente(clienteDTO.getNomeCliente());
		cliente.setCpf(clienteDTO.getCpf().replace(".", "").replace("-", ""));
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
		cliente.setEmail(clienteDTO.getEmail());

		return cliente;
	}

	public void salvar(ClienteDTO clienteDTO) {
		ClienteModel cliente = new ClienteModel();
		ClienteModel clienteSalvar = toModel(clienteDTO, cliente);
		clienteRepository.save(clienteSalvar);
	}

	public List<ClienteDTO> listarTodos() {
		List<ClienteModel> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();

		for (ClienteModel cliente : listaCliente) {
			ClienteDTO clienteDTO = new ClienteDTO();
			toDTO(clienteDTO, cliente);
			listaClienteDTO.add(clienteDTO);
		}

		return listaClienteDTO;
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<ClienteModel> cliente = clienteRepository.findById(idCliente);

		// cliente vazio
		ClienteModel clienteNoBanco = new ClienteModel();
		// clienteDTO vazio
		ClienteDTO clienteDTO = new ClienteDTO();

		if (cliente.isPresent()) {
			// cliente vazio recebe cliente do banco
			clienteNoBanco = cliente.get();
			clienteDTO = toDTO(clienteDTO, clienteNoBanco);
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado");

	}

	public void atualizarCliente(Integer idCliente, ClienteDTO clienteDTO)  {
		Optional<ClienteModel> cliente = clienteRepository.findById(idCliente);
		ClienteModel clienteNoBanco = new ClienteModel();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			if (clienteDTO.getNomeCliente() != null)
				clienteNoBanco.setNomeCliente(clienteDTO.getNomeCliente());

			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}

			if (clienteDTO.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}

			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}

			clienteRepository.save(clienteNoBanco);
		}
		
	}
	
	public void delete(Integer idCliente){
		clienteRepository.deleteById(idCliente);
		
	}
	
	
	
}
