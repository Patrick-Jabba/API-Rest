package org.serratec.backend.projeto08.borracharia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JwtWebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioDetalheService usuarioDetalhe;
	
	@Autowired
	//private JwtRequestsFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetalhe);
	}
	
	@Bean
	public PasswordEncoder codificarSenha() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
