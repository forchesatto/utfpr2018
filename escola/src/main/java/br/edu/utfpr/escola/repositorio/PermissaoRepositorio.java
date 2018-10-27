package br.edu.utfpr.escola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Permissao;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Long> {

}
