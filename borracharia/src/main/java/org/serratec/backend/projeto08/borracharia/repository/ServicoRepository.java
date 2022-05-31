package org.serratec.backend.projeto08.borracharia.repository;

import java.util.List;

import org.serratec.backend.projeto08.borracharia.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, Integer> {

	List<Servico> findAllByOrderByIdServicoDesc();

	
}
