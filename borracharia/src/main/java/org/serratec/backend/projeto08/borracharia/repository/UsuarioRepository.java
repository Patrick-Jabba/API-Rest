package org.serratec.backend.projeto08.borracharia.repository;

import org.serratec.backend.projeto08.borracharia.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

}
