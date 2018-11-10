package br.edu.utfpr.escola.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.escola.model.Curso;
import br.edu.utfpr.escola.model.LabelValue;
import br.edu.utfpr.escola.repositorio.CursoRepositorio;

@Controller
@RequestMapping("/curso") //todas as urls irão iniciar com /curso
public class CursoController {

	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@GetMapping("/")
	public String lista(Model model){
		//${dados} será a variável disponível no template thymeleaf
		model.addAttribute("dados",cursoRepositorio.findAll());
		return "curso/lista"; //arquivo .html dentro da pasta resources/templates
	}
	
	@GetMapping("/pesquisa")
	public String pesquisa(@RequestParam String termo, Model model){
		model.addAttribute("dados",cursoRepositorio
				.findByNomeLike("%"+termo+"%"));
		return "curso/lista";
	}
	
	@GetMapping("/autocomplete")
	@ResponseBody
	public List<LabelValue> autocomplete(@RequestParam String term, 
			Model model){
		return cursoRepositorio.findByNomeLikeLV("%"+term+"%");
	}
	
	@GetMapping("/novo")
	public String novo(Model model){
		model.addAttribute("curso", new Curso());
		return "curso/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Curso curso, 
			BindingResult erros, Model model, 
			RedirectAttributes redirect){
		if(erros.hasErrors()){
			return "curso/formulario";
		}
		redirect.addFlashAttribute("mensagem", "Registro salvo com sucesso");
		cursoRepositorio.save(curso);
		return "redirect:/curso/";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable Long codigo, Model model){
		model.addAttribute("curso", cursoRepositorio
							.findById(codigo).orElse(new Curso()));
		return "curso/formulario";
	}
	@GetMapping("/remover/{codigo}")
	public String remover(@PathVariable Long codigo, Model model){
		cursoRepositorio.deleteById(codigo);
		return "redirect:/curso/";
	}
	
	
	
	
	
}
