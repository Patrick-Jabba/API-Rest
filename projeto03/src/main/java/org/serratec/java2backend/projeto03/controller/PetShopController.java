package org.serratec.java2backend.projeto03.controller;

import java.util.List;

import org.serratec.java2backend.projeto03.model.PetShop;
import org.serratec.java2backend.projeto03.service.PetShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {

	
	@Autowired
	PetShopService petShopService;
	
	@RequestMapping ("/petshop")
	public List<PetShop> getPetShop(){
		return petShopService.listaPetShopes();
	}
	
	
	
}
