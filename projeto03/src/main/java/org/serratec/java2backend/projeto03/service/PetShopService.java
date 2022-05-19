package org.serratec.java2backend.projeto03.service;

import java.util.Arrays;
import java.util.List;

import org.serratec.java2backend.projeto03.model.PetShop;
import org.springframework.stereotype.Service;

@Service
public class PetShopService {

	private List<PetShop> petShopes =
			
			Arrays.asList(
			  new PetShop(1, "Cão & Coça", "www.c&c.com.br"),
			  new PetShop(2, "Gato Mia", "www.naoehmarcopolo.com.br"),
			  new PetShop(3, "Kem Não tem Cão tosa o seu Gato", "www.piadasdepet.com.br")
			);
			
	
	public List<PetShop> listaPetShopes(){
		return this.petShopes;
	}
	
}
