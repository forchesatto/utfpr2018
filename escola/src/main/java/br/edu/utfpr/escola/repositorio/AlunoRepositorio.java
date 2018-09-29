package br.edu.utfpr.escola.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.escola.model.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

	List<Aluno> findByNomeLike(String nome);

	@Query("select a from Aluno a where a.dataNascimento > ?1")
	List<Aluno> dataNascimentoMaiorQue(LocalDate data);

	List<Aluno> dataNascimentoMenorQue(LocalDate data);

}
