package org.serratec.projeto04.controller;

import java.util.List;

import org.serratec.projeto04.model.ContaModel;
import org.serratec.projeto04.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class APIController {

	@Autowired
	ContaService contaService;
	
	
	@GetMapping("/conta")
	public List<ContaModel> getTodo() {
		return contaService.listaTodo();
	}
	

}
