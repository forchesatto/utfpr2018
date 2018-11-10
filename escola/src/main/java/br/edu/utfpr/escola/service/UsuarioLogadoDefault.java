package br.edu.utfpr.escola.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.edu.utfpr.escola.model.Usuario;

@Component
public class UsuarioLogadoDefault implements UsuarioLogado {

	@Override
	public Usuario getUsuario() {
		SecurityContext context = SecurityContextHolder.getContext();
		if(context != null){
			Authentication auth = context.getAuthentication();
			if(auth != null && auth.getPrincipal() 
										instanceof UserDetails){
				return (Usuario) auth.getPrincipal();
			}
		}
		return null;
	}

}
