package serratec.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serratec.monitoria.dto.PessoaDTO;
import serratec.monitoria.exception.CustomException;
import serratec.monitoria.model.Pessoa;
import serratec.monitoria.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaService() {
		System.out.println("Fui iniciado....");
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();

	}

	public Pessoa findById(Long id) throws CustomException {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new CustomException("pessoa não encontrada com id " + id);
		}
		return optional.get();
	}

	public PessoaDTO create(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setSobrenome(pessoaDTO.getSobrenome());
		
		Pessoa pessoaSave = pessoaRepository.save(pessoa);
		
		pessoaDTO.setId(pessoaSave.getId());
		return pessoaDTO;
	}

	public Pessoa update(PessoaDTO pessoaDTO, Long id) throws CustomException {
		Pessoa pessoaFind = this.findById(id);

		if(Strings.isNotEmpty(pessoaDTO.getNome())) {
			pessoaFind.setNome(pessoaDTO.getNome());
		}
		
		if(Strings.isNotEmpty(pessoaDTO.getSobrenome())) {
			pessoaFind.setSobrenome(pessoaDTO.getSobrenome());
		}
		
		pessoaRepository.save(pessoaFind);
		pessoaDTO.setId(pessoaFind.getId());
		
		return pessoaFind;
	}
	
	public void delete(Long id) throws CustomException {
		this.findById(id);
		pessoaRepository.deleteById(id);
	}

}
