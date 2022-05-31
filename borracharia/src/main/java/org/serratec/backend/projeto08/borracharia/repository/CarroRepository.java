package org.serratec.backend.projeto08.borracharia.repository;

import org.serratec.backend.projeto08.borracharia.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository <CarroModel, Integer> {

}
