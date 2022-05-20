package org.serratec.projeto05.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto05.model.PetShopModel;
import org.springframework.stereotype.Service;

@Service
public class PetShopService {

	List<PetShopModel> listaPetShop = new ArrayList<>();

	// Get
	public List<PetShopModel> listarLojas() {
		return this.listaPetShop;
	}

	// Get by ID
	public PetShopModel buscarPorId(Integer idLoja) {
		PetShopModel petShopLoja = new PetShopModel();
		for (PetShopModel petShopLista : listaPetShop) {
			if (petShopLista.getId().equals(idLoja)) {
				petShopLoja = petShopLista;
			}
		}
		return petShopLoja;
	}

	// Post para popular listaPetShop
	public void adicionar(PetShopModel petShop) {
		listaPetShop.add(petShop);
	}

	// Put para atualizar um json pelo ID dele sem possibilidade de alterar seu ID
	public void atualizarPorId(Integer idLoja, PetShopModel petShopDaApi) {
		PetShopModel petShopLojaAchada = new PetShopModel();
		for (PetShopModel petShopLista : listaPetShop) {
			if (petShopLista.getId().equals(idLoja)) {
				petShopLojaAchada = petShopLista;
				
				petShopLojaAchada.setNome(petShopDaApi.getNome());
				petShopLojaAchada.setSite(petShopDaApi.getSite());

			}
		}
	}

	// Put para atualizar um objeto da Lista por usa posição na Lista podendo alterar inclusive o ID
	public void atualizar(Integer posicaoLista, PetShopModel petShopDaApi) {
		PetShopModel petShopDaListaCriada = new PetShopModel();
		petShopDaListaCriada = listaPetShop.get(posicaoLista);

		petShopDaListaCriada.setId(petShopDaApi.getId());
		petShopDaListaCriada.setNome(petShopDaApi.getNome());
		petShopDaListaCriada.setSite(petShopDaApi.getSite());

	}
	
	//Delete para deletar o objeto
	public void deletar(int posicaoLista) {
		listaPetShop.remove(posicaoLista);
		
	}
	
	

}
