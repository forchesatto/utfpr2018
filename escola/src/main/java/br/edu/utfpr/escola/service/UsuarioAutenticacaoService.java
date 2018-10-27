package br.edu.utfpr.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.escola.repositorio.UsuarioRepositorio;

@Service
public class UsuarioAutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepositorio.findByUsername(username);
	}
	
	
	
	
	
	
	

}
