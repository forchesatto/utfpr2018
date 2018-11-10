package br.edu.utfpr.escola.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.escola.model.Curso;
import br.edu.utfpr.escola.model.LabelValue;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {

	@Query("select new br.edu.utfpr.escola.model.LabelValue"
			+ "(a.codigo, a.nome) "
			+ "from Curso a "
			+ "where a.nome like ?1")
	List<LabelValue> findByNomeLikeLV(String term);
	
	List<Curso> findByNomeLike(String nome);
	
	
	
	
	
	
	
	
	
	
	

}
