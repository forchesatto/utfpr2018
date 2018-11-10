package br.edu.utfpr.escola.service;

import br.edu.utfpr.escola.model.Usuario;

public interface UsuarioLogado {

	/**
	 * Retorna o usuário que se encontra na sessão.
	 * @return {@link Usuario}
	 */
	Usuario getUsuario();
}
