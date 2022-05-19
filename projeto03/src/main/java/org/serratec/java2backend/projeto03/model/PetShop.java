package org.serratec.java2backend.projeto03.model;

public class PetShop {

	private Integer id;
	private String nome;
	private String site;

	public PetShop() {

	}

	public PetShop(Integer id, String nome, String site) {
		super();
		this.id = id;
		this.nome = nome;
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
