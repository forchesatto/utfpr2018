package br.edu.utfpr.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.escola.model.Usuario;
import br.edu.utfpr.escola.repositorio.PermissaoRepositorio;
import br.edu.utfpr.escola.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PermissaoRepositorio permissaoRepositorio;
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	
	@GetMapping("/")
	public String lista(Model model){
		model.addAttribute("dados",usuarioRepositorio.findAll());
		return "usuario/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("permissoes", permissaoRepositorio.findAll());
		return "usuario/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario){
		if(usuario.getPassword().isEmpty()){ 
			if(usuario.getCodigo() != null){
				Usuario usuarioAtual = usuarioRepositorio
							.findById(usuario.getCodigo()).get();
				usuario.setPassword(usuarioAtual.getPassword());
			}
		} else {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));	
		}
		usuarioRepositorio.save(usuario);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable Long codigo, Model model){
		model.addAttribute("usuario", usuarioRepositorio
							.findById(codigo).orElse(new Usuario()));
		model.addAttribute("permissoes", permissaoRepositorio.findAll());
		return "usuario/formulario";
	}
	@GetMapping("/remover/{codigo}")
	public String remover(@PathVariable Long codigo, Model model){
		usuarioRepositorio.deleteById(codigo);
		return "redirect:/usuario/";
	}
}
