package br.edu.utfpr.escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("nome", "luiz");
		return "index";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model){
		model.addAttribute("errorLogin", true);
		return "login";
	}
	
	
	
	
	
	
}
