package org.serratec.backend.projeto08.borracharia.repository;

import java.util.List;

import org.serratec.backend.projeto08.borracharia.dto.RelatorioDTOInterface;
import org.serratec.backend.projeto08.borracharia.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, Integer> {

	List<Servico> findAllByOrderByIdServicoDesc();

	@Query(value="select \r\n"
			+ "c2.CLIENTE_TX_NOME_CLIENTE as cliente,\r\n"
			+ "c.CARRO_TX_MODELO as modelo,\r\n"
			+ "s.SERVICO_TX_SERVICO_PRESTADO as descricaoServico,\r\n"
			+ "s.SERVICO_NUM_VALOR as valor\r\n"
			+ "from servico s join carro c on (s.CARRO_CLIENTE =c.CARRO_CD_CARRO )\r\n"
			+ "join cliente c2 on(c2.cliente_cd_cliente=c.CD_CARRO_CLIENTE)"
			+ "order by s.SERVICO_CD_SERVICO \r\n"
			+ "desc\r\n"
			+ "limit 5", nativeQuery=true)
	List<RelatorioDTOInterface> relatorio();
}
