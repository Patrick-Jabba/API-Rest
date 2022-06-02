package org.serratec.backend.projeto08.borracharia.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.projeto08.borracharia.dto.UsuarioDTO;
import org.serratec.backend.projeto08.borracharia.model.UsuarioModel;
import org.serratec.backend.projeto08.borracharia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	private UsuarioDTO mapToDTO(UsuarioModel usuario, UsuarioDTO udto) {
		udto.setIdUsuario(usuario.getIdUsuario());
		udto.setUsername(usuario.getUsername());
		udto.setPassword(usuario.getPassword());
		udto.setPassword(encoder.encode(usuario.getPassword()));
		return udto;
	}
	
	private UsuarioModel mapToModel(UsuarioModel usuario, UsuarioDTO dto) {
		usuario.setUsername(dto.getUsername());
		usuario.setPassword(encoder.encode(dto.getPassword()));
		return usuario;
	}
// ======================= Métodos HTTP ============
	public UsuarioDTO buscar(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<UsuarioDTO> buscarTodos(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorLogin(String username) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getUsername().equals(username))
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Integer salvar(UsuarioDTO usuarioDTO) {
		UsuarioModel usuario = new UsuarioModel();
		mapToModel(usuario, usuarioDTO);
		usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}
	
}
