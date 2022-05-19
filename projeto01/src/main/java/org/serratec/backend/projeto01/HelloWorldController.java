package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@GetMapping("/hello-world")
	//http//localhost:8080/hello-world?nome=teste
	public String helloWorld(@RequestParam String nome, @RequestParam String sobrenome) {
		return String.format("Hello World! %s", nome );
	}
	
	@GetMapping("/soma/{numero1}/{numero2}")
	//http://localhost:8080/hello-world/teste
	public String helloWorld2(@PathVariable double numero1, @PathVariable double numero2) {
		if(numero2 == 0) {
			return "Não pode dividir por zero";
		}
		return String.valueOf(numero1 / numero2);
	}
	
	@RequestMapping("/maiuscula")
	public String maiuscula(String valor) {
		return valor.toUpperCase();
	}
	
	//http://localhost:8080/soma?numero1=2&numero2=5
	
}
