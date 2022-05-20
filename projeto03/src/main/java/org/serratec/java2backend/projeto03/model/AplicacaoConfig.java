package org.serratec.java2backend.projeto03.model;

import java.util.List;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("aplicacao")
public class AplicacaoConfig {

	private int valor1;
	private String valor2;
	private String[] array1;
	private int[] arra2;
	private List<Integer> lista;
	private List<Todo> todos;

	public AplicacaoConfig() {
	}

	public AplicacaoConfig(int valor1, String valor2, String[] array1, int[] arra2, List<Integer> lista,
			List<Todo> todos) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.array1 = array1;
		this.arra2 = arra2;
		this.lista = lista;
		this.todos = todos;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	public String[] getArray1() {
		return array1;
	}

	public void setArray1(String[] array1) {
		this.array1 = array1;
	}

	public int[] getArra2() {
		return arra2;
	}

	public void setArra2(int[] arra2) {
		this.arra2 = arra2;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

}
