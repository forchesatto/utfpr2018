package br.edu.utfpr.escola.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Disciplina;

public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Long> {

	@EntityGraph(attributePaths="curso")
	List<Disciplina> findAll();
}
