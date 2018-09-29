package br.edu.utfpr.escola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {

}
