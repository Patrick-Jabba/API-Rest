package org.serratec.backend.projeto04versao2.repository;

import org.serratec.backend.projeto04versao2.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Integer>{

}
