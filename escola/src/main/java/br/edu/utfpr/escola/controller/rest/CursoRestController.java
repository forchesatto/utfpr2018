package br.edu.utfpr.escola.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.escola.model.Curso;
import br.edu.utfpr.escola.repositorio.CursoRepositorio;

@RestController
@RequestMapping("/rest/curso")
public class CursoRestController {

	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@GetMapping("/{codigo}")
	public Curso visualizar(@PathVariable Long codigo){
		return cursoRepositorio.findById(codigo)
										.orElse(new Curso());
	}
	@PostMapping("/")
	public void salvar(@RequestBody Curso curso){
		cursoRepositorio.save(curso);
	}
	
	
	
	
	
	
	
}
