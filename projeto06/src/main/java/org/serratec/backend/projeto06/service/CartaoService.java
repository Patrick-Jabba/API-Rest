package org.serratec.backend.projeto06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.dto.CartaoDTO;
import org.serratec.backend.projeto06.exception.CartaoException;
import org.serratec.backend.projeto06.model.CartaoModel;
import org.serratec.backend.projeto06.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository cartaoRepository;

	public CartaoDTO transformarModelEmDTO(CartaoModel cartaoModel, CartaoDTO cartaoDTO) {
		cartaoDTO.setDataValidade(cartaoModel.getDataValidade());
		cartaoDTO.setIdCartao(cartaoModel.getIdCartao());
		cartaoDTO.setLimiteCartao(cartaoModel.getLimiteCartao());
		cartaoDTO.setNomeTitular(cartaoModel.getNomeTitular());
		cartaoDTO.setNumeroCartao(cartaoModel.getNumeroCartao());

		return cartaoDTO;
	}

	public CartaoModel transformarDTOEmModel(CartaoModel cartaoModel, CartaoDTO cartaoDTO) {
		cartaoModel.setDataValidade(cartaoDTO.getDataValidade());
		cartaoModel.setIdCartao(cartaoDTO.getIdCartao());
		cartaoModel.setLimiteCartao(cartaoDTO.getLimiteCartao());
		cartaoModel.setNomeTitular(cartaoDTO.getNomeTitular());
		cartaoModel.setNumeroCartao(cartaoDTO.getNumeroCartao());

		return cartaoModel;
	}

	public String salvar(CartaoDTO cartaoDTO) {
		CartaoModel cartaoModel = new CartaoModel();
		transformarDTOEmModel(cartaoModel, cartaoDTO);
		cartaoRepository.save(cartaoModel);
		return "O cartão criado foi com o id: " + cartaoModel.getIdCartao();
	}

	public CartaoDTO buscarPorId(Integer idCartao) throws CartaoException {
		Optional<CartaoModel> cartaoModel = cartaoRepository.findById(idCartao);

		CartaoModel cartaoNoBanco = new CartaoModel();
		CartaoDTO cartaoDTO = new CartaoDTO();

		if (cartaoModel.isPresent()) {
			cartaoNoBanco = cartaoModel.get();
			transformarModelEmDTO(cartaoNoBanco, cartaoDTO);
			return cartaoDTO;
		}
		throw new CartaoException("Cartão com o id informado não encontrado");

	}

	public void deletar(Integer idCartao) {
		cartaoRepository.deleteById(idCartao);
	}

	public String atualizar(Integer idCartao, CartaoDTO cartaoDTO) throws CartaoException {
		Optional<CartaoModel> cartao = cartaoRepository.findById(idCartao);
		CartaoModel cartaoNoBanco = new CartaoModel();

		if (cartao.isPresent()) {
			cartaoNoBanco = cartao.get();
			if (cartaoDTO.getDataValidade() != null) {
				cartaoNoBanco.setDataValidade(cartaoDTO.getDataValidade());
			}
			if (cartaoDTO.getLimiteCartao() != null) {
				cartaoNoBanco.setLimiteCartao(cartaoDTO.getLimiteCartao());
			}
			if (cartaoDTO.getNomeTitular() != null) {
				cartaoNoBanco.setNomeTitular(cartaoDTO.getNomeTitular());
			}
			if (cartaoDTO.getNumeroCartao() != null) {
				cartaoNoBanco.setNumeroCartao(cartaoDTO.getNumeroCartao());
			}
			cartaoRepository.save(cartaoNoBanco);
			return "O cartão com o id " + cartaoNoBanco.getIdCartao() + "foi atualizado";
		}
		throw new CartaoException("O cartao não foi atualizado!");
	}

	public List<CartaoDTO> buscarTodos(){
		List<CartaoModel> listaCartaoModel = cartaoRepository.findAll();
		List<CartaoDTO> listaCartaoDTO = new ArrayList<>();
		
		
		for (CartaoModel cartaoModel : listaCartaoModel) {
			CartaoDTO cartaoDTO = new CartaoDTO();
			transformarModelEmDTO(cartaoModel, cartaoDTO);
			listaCartaoDTO.add(cartaoDTO);
		}
		return listaCartaoDTO;
		
	}
	
	public void salvarListaCartao(List<CartaoDTO> listaCartaoDTO) {
	
		
		for (CartaoDTO cartaoDTO : listaCartaoDTO) {
			CartaoModel cartaoModel = new CartaoModel();
			transformarDTOEmModel(cartaoModel, cartaoDTO);
			cartaoRepository.save(cartaoModel);
	
		}
	}
	
	
	
	
	
}
