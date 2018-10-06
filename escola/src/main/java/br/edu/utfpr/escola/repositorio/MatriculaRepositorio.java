package br.edu.utfpr.escola.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.escola.model.Matricula;

public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {

	@Query("select m from Matricula m "
			+ "join fetch m.disciplina d "
			+ "join fetch m.aluno a "
			+ "join fetch d.curso c ")
	List<Matricula> todasMatriculasCompleta();
	
	
	@EntityGraph(value="Matricula.completo")
	List<Matricula> findAll();
	
	@EntityGraph(attributePaths={"aluno",
			"disciplina", 
			"disciplina.curso"})
	Matricula findByCodigo(Long codigo);
	
	
	
	
	
	
	
	
	
}
