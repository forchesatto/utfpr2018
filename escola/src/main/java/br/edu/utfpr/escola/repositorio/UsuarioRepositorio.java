package br.edu.utfpr.escola.repositorio;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	@EntityGraph(attributePaths="permissoes")
	Usuario findByUsername(String username);

}
