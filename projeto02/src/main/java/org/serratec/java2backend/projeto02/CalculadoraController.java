package org.serratec.java2backend.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CalculadoraController {
	
	@GetMapping("/home")
	public String Welcome() {
		return "Bem-vindo a calculadora rudimentar. Navegue pelos endpoints /soma; /subtracao; /multiplicacao ou /divisao";
	}
	
	
	@GetMapping("/soma")
	public Double soma(@RequestParam Double valor1, Double valor2) {

		return valor1 + valor2;
	}

	@GetMapping("/subtracao")
	public Double substracao(@RequestParam Double valor1, Double valor2) {
		return valor1 - valor2;
	}

	@GetMapping("/multiplicacao")
	public Double multiplicacao(@RequestParam Double valor1, Double valor2) {

		return valor1 * valor2;
	}

	@GetMapping("/divisao/{valor1}/{valor2}")
	public String divisao(@PathVariable double valor1, @PathVariable double valor2) {
		if(valor1 == 0 || valor2 == 0) {
			return "Não é possível dividir por zero!";
		}
		return String.valueOf(valor1 / valor2);

	}
	
	

}
