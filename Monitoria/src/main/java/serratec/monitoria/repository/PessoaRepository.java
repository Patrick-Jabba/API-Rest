package serratec.monitoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import serratec.monitoria.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
