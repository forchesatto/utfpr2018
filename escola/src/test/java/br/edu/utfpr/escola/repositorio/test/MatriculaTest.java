package br.edu.utfpr.escola.repositorio.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import br.edu.utfpr.escola.MainEscola;
import br.edu.utfpr.escola.model.Aluno;
import br.edu.utfpr.escola.model.Curso;
import br.edu.utfpr.escola.model.Disciplina;
import br.edu.utfpr.escola.model.Matricula;
import br.edu.utfpr.escola.repositorio.AlunoRepositorio;
import br.edu.utfpr.escola.repositorio.CursoRepositorio;
import br.edu.utfpr.escola.repositorio.DisciplinaRepositorio;
import br.edu.utfpr.escola.repositorio.MatriculaRepositorio;
import br.edu.utfpr.escola.service.MatriculaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MainEscola.class)

@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, 

	DbUnitTestExecutionListener.class })


public class MatriculaTest {

	@Autowired
	private MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@Autowired
	private MatriculaService matriculaService;
	
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
		matricula = matriculaService.matricular(matricula);
		
		assertNotNull(matricula.getCodigo());
		
	}
	
	@DatabaseSetup("/db/matriculas.xml")
	@Test
	public void deveRetornarMatricula(){
		List<Matricula> dados = matriculaRepositorio.findAll();
		dados.forEach(matricula->{
			System.out.println(matricula.getAluno().getNome());
			System.out.print(" - "+matricula.getDisciplina()
								.getNome());
			System.out.print(" - "+matricula.getDisciplina()
								.getCurso().getNome());
		});
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
