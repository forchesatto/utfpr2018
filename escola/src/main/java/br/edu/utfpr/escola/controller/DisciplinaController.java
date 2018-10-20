package br.edu.utfpr.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.escola.model.Disciplina;
import br.edu.utfpr.escola.repositorio.CursoRepositorio;
import br.edu.utfpr.escola.repositorio.DisciplinaRepositorio;

@Controller
@RequestMapping("/disciplina") //todas as urls irão iniciar com /curso
public class DisciplinaController {

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@GetMapping("/")
	public String lista(Model model){
		//${dados} será a variável disponível no template thymeleaf
		model.addAttribute("dados",disciplinaRepositorio.findAll());
		return "disciplina/lista"; //arquivo .html dentro da pasta resources/templates
	}
	
	@GetMapping("/novo")
	public String novo(Model model){
		model.addAttribute("disciplina", new Disciplina());
		model.addAttribute("cursos", cursoRepositorio.findAll());
		return "disciplina/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Disciplina disciplina){
		disciplinaRepositorio.save(disciplina);
		return "redirect:/disciplina/";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable Long codigo, Model model){
		model.addAttribute("disciplina", disciplinaRepositorio
							.findById(codigo).orElse(new Disciplina()));
		model.addAttribute("cursos", cursoRepositorio.findAll());
		return "disciplina/formulario";
	}
	@GetMapping("/remover/{codigo}")
	public String remover(@PathVariable Long codigo, Model model){
		disciplinaRepositorio.deleteById(codigo);
		return "redirect:/disciplina/";
	}
	
	
	
	
	
}
