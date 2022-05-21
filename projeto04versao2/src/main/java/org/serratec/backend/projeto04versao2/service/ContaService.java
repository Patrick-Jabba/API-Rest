package org.serratec.backend.projeto04versao2.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto04versao2.exception.CustomException;
import org.serratec.backend.projeto04versao2.model.ContaModel;
import org.serratec.backend.projeto04versao2.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	//GET
	public List<ContaModel> findAll(){
		return contaRepository.findAll();
	}

	//GET
	public ContaModel findById(Integer idConta) {
		Optional<ContaModel> conta = contaRepository.findById(idConta);

		// conta vazia / instanciação
		ContaModel contaNoBanco = new ContaModel();

		if (conta.isPresent()) {
			// conta vazia
			contaNoBanco = conta.get();
		}
		return contaNoBanco;
	}
	
	//CREATE / POST
	public void create(ContaModel conta) {
		contaRepository.save(conta);
	}
	
	//CREATE / POST Mais de uma conta por vez  
	public void createAllAccounts(List<ContaModel> listaContas) {
		contaRepository.saveAll(listaContas);
	}
	
	//POST Recebe uma operação como parametro e a partir dai atualiza o saldo
	public void transfere (
			Integer idConta,
			String operacao,
			Double valorParametro) throws CustomException {
			ContaModel contaNoBanco = findById(idConta);
			 
	
		if (operacao.equalsIgnoreCase("credito")) {
			contaNoBanco.setSaldo(valorParametro + contaNoBanco.getSaldo());
		}
		if (operacao.equalsIgnoreCase("debito")){
			if (contaNoBanco.getSaldo() < valorParametro) {
				throw new CustomException();
			} else {
				contaNoBanco.setSaldo(contaNoBanco.getSaldo() - valorParametro);
			}
		}
		contaRepository.save(contaNoBanco);
	}

	//UPDATE / PUT
	public void update(Integer idConta, ContaModel conta) {
		ContaModel contaNoBanco = findById(idConta);

		if (conta.getTitular() != null) {
			contaNoBanco.setTitular(conta.getTitular());

		}

		if (conta.getNumeroConta() != null) {
			contaNoBanco.setNumeroConta(conta.getNumeroConta());
		}

		contaRepository.save(contaNoBanco);
	}
	
	// DELETE
	public void delete(Integer idConta) {
		contaRepository.deleteById(idConta);
	}

		
}