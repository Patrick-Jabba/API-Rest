package org.serratec.backend.projeto06.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.model.Cliente;
import org.serratec.backend.projeto06.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente buscarPorId(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		// cliente vazio
		Cliente clienteNoBanco = new Cliente();

		if (cliente.isPresent()) {
			// cliente vazio
			clienteNoBanco = cliente.get();
		}
		return clienteNoBanco;
	}

	public void atualizar(Integer idCliente, Cliente cliente) {
		Cliente clienteNoBanco = buscarPorId(idCliente);
		
		if (cliente.getCpf() != null) {
			clienteNoBanco.setCpf(cliente.getCpf());
		}
		if (cliente.getDataNascimento() != null) {
			clienteNoBanco.setDataNascimento(cliente.getDataNascimento());
		}
		if (cliente.getEmail() != null) {
			clienteNoBanco.setEmail(cliente.getEmail());
		}

		if (cliente.getNumeroTelefone() != null) {
			clienteNoBanco.setNumeroTelefone(cliente.getEmail());
		}

		clienteRepository.save(clienteNoBanco);
	}
	
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	
	public void salvarTodos(List<Cliente> listaCliente) {
		clienteRepository.saveAll(listaCliente);
	}
	
	
}
