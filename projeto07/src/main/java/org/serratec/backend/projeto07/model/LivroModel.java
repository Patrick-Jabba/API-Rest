package org.serratec.backend.projeto07.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Livro")
public class LivroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_livro")
	private Long idLivro;
	
	@NotNull
	@Column(name = "livro_tx_titulo")
	@Size(min = 5, max = 30)
	private String titulo;
	
	@NotNull
	@Column(name = "livro_tx_genero")
	@Size(min = 3, max = 20)
	private String genero;
	
	@NotNull
	@Column(name = "livro_tx_autor")
	@Size(min = 10, max = 40)
	private String autor;
	
	@NotNull
	@Column(name = "livro_dt_publicacao")
	private LocalDate dataPublicacao;
	
	public LivroModel() {}
}
