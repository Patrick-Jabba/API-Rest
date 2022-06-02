package org.serratec.backend.projeto08.borracharia.repository;

import java.util.Optional;

import org.serratec.backend.projeto08.borracharia.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
	
	@Query(value = "FROM UsuarioModel u WHERE u.username = ?1")
	Optional<UsuarioModel> buscarPorLogin(String login);
}
