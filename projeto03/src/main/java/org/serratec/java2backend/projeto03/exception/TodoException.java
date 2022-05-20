package org.serratec.java2backend.projeto03.exception;

public class TodoException extends Exception {

	private static final long serialVersionUID = 1l;

	private Integer id;

	public TodoException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
