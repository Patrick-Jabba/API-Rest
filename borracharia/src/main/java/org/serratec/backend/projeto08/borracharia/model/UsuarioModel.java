package org.serratec.backend.projeto08.borracharia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name = "usuario_nome")
	private String username;
	
	@Column(name = "usuario_senha")
	private String password;
	
	public UsuarioModel() {}
	
	
}
