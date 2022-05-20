package org.serratec.projeto04.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto04.exception.OperacaoException;
import org.serratec.projeto04.model.ContaModel;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	List<ContaModel> listaContas = new ArrayList<>();

	// Método BUSCAR GET
	public List<ContaModel> listarContas() {
		return this.listaContas;
	}

	// Método GET pelo numero da Conta
	public ContaModel listarContasPorNumero(Integer numeroConta) {
		ContaModel contaBuscada = new ContaModel();
		for (ContaModel contaLista : listaContas) {
			if (contaLista.getNumero().equals(numeroConta)) {
				contaBuscada = contaLista;
			}
		}
		return contaBuscada;
	}

	// Método ADICIONAR POST
	public void adicionar(ContaModel conta) {
		listaContas.add(conta);

	}

	// Método Atualizar Conta Put somente titular e Numero
	public void atualizar(Integer posicaoContaLista, ContaModel contaAtualizada) {
		ContaModel contaBuscada = new ContaModel();
		contaBuscada = listaContas.get(posicaoContaLista);

		contaBuscada.setTitular(contaAtualizada.getTitular());
		contaBuscada.setNumero(contaAtualizada.getNumero());
	}

	// Soma um valor informado atraves de Parametro para o saldo da Conta Informada
	public void transfere (
			Integer numeroConta,
			String operacao,
			Double valorParametro) throws OperacaoException {
		ContaModel conta = new ContaModel();
		conta = listaContas.get(numeroConta);

		if (operacao.equalsIgnoreCase("credito")) {
			conta.setSaldo(valorParametro + conta.getSaldo());
		}
		if (operacao.equalsIgnoreCase("debito")){
			if (conta.getSaldo() < valorParametro) {
				throw new OperacaoException();
			} else {
				conta.setSaldo(conta.getSaldo() - valorParametro);
			}
		}
	}

	// Remove a Conta cujo numero foi passado
	public void deletar(int numeroConta) {
		for (ContaModel contaLista : listaContas) {
			if (contaLista.getNumero().equals(numeroConta))
				listaContas.remove(numeroConta);

		}

	}

}
