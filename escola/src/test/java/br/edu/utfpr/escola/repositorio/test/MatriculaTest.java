package br.edu.utfpr.escola.repositorio.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.utfpr.escola.MainEscola;
import br.edu.utfpr.escola.model.Aluno;
import br.edu.utfpr.escola.model.Curso;
import br.edu.utfpr.escola.model.Disciplina;
import br.edu.utfpr.escola.model.Matricula;
import br.edu.utfpr.escola.repositorio.AlunoRepositorio;
import br.edu.utfpr.escola.repositorio.CursoRepositorio;
import br.edu.utfpr.escola.repositorio.DisciplinaRepositorio;
import br.edu.utfpr.escola.repositorio.MatriculaRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MainEscola.class)
public class MatriculaTest {

	@Autowired
	private MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@After
	public void after(){
		matriculaRepositorio.deleteAll();
	}
	
	
	@Test
	public void deveMatricularAluno(){
		Aluno aluno = new Aluno("André", LocalDate.of(2001, 10, 10));
		aluno = alunoRepositorio.save(aluno);
		Curso curso = new Curso("JAVA");
		curso = cursoRepositorio.save(curso);
		Disciplina disciplina = new Disciplina("POO", curso);
		disciplina = disciplinaRepositorio.save(disciplina);
		
		Matricula matricula = new Matricula(aluno, disciplina);
		matricula = matriculaRepositorio.save(matricula);
		
		assertNotNull(matricula.getCodigo());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
