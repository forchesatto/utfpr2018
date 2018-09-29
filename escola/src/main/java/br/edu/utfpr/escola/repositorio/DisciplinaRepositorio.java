package br.edu.utfpr.escola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Disciplina;

public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Long> {

}
