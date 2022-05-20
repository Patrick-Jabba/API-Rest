package org.serratec.projeto04.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto04.model.ContaModel;
import org.springframework.stereotype.Service;


@Service
public class ContaService {

	List<ContaModel> listaConta = new ArrayList<>();

	//Método BUSCAR GET
	public List<ContaModel> listaTodo() {
		return this.listaConta;
	}
	
	//Método ADICIONAR POST
	public void adicionar(ContaModel conta) {
		listaConta.add(conta);
		
	}
	
	
}
