package org.serratec.projeto05.controller;


import org.serratec.projeto05.model.PetShopModel;
import org.serratec.projeto05.service.PetShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PetController {
	
	@Autowired
	PetShopService petShopService;

	@PostMapping("/adicionar")
		public ResponseEntity<Void> adicionar(@RequestBody PetShopModel petShop){
		petShopService.adicionar(petShop);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
