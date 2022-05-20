package org.serratec.java2backend.projeto03.controller;

import org.serratec.java2backend.projeto03.model.AplicacaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacaoController {

	
	@Autowired
	private AplicacaoConfig aplicacaoConfig;
	
	@GetMapping("/config")
	public AplicacaoConfig retornarConfig() {
		return aplicacaoConfig;
	}
	
}
