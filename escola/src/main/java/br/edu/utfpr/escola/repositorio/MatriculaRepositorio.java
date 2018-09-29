package br.edu.utfpr.escola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.escola.model.Matricula;

public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {

}
