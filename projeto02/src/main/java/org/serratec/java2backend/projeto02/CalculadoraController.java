package org.serratec.java2backend.projeto02;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
	
	@RequestMapping("")
	public String Welcome() {
		return "Bem-vindo a calculadora rudimentar. Navegue pelos endpoints /soma; /subtracao; /multiplicacao ou /divisao";
	}
	
	
	@RequestMapping("/soma")
	public Double soma(@RequestParam Double valor1, Double valor2) {

		return valor1 + valor2;
	}

	@RequestMapping("/subtracao")
	public Double substracao(@RequestParam Double valor1, Double valor2) {
		return valor1 - valor2;
	}

	@RequestMapping("/multiplicacao")
	public Double multiplicacao(@RequestParam Double valor1, Double valor2) {

		return valor1 * valor2;
	}

	@RequestMapping("/divisao")
	public Double divisao(@RequestParam Double valor1, Double valor2, Double valor3) {

		return valor1 / valor2;

	}

}
