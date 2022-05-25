package org.serratec.backend.projeto07.repository;

import java.util.List;

import org.serratec.backend.projeto07.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository <LivroModel, Long> {

	public List<LivroModel> findAllByOrderByTituloAsc();

	public List<LivroModel> findAllByOrderByTituloDesc();
	
	public List<LivroModel> findAllByOrderByIdLivroDesc();
	
	
}
