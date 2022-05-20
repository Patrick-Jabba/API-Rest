package org.serratec.projeto05.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto05.model.PetShopModel;
import org.springframework.stereotype.Service;

@Service
public class PetShopService {

	List<PetShopModel> listaPetShop = new ArrayList<>();

	public void adicionar(PetShopModel petShop) {
		listaPetShop.add(petShop);
	}

	

}
