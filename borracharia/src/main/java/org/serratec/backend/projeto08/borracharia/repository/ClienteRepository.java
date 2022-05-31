package org.serratec.backend.projeto08.borracharia.repository;

import org.serratec.backend.projeto08.borracharia.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Integer>{

		
}
