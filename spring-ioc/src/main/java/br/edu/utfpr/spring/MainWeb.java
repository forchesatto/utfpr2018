package br.edu.utfpr.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.spring.regras.CalculadoraImposto;

@SpringBootApplication
public class MainWeb {

	public static void main(String[] args) {
		SpringApplication.run(MainWeb.class, args);
	}

	@RestController
	class Controller{
		
		@Autowired
		private CalculadoraImposto calculadoraImposto;
		
		@GetMapping("/")
		Double teste(){
			return calculadoraImposto.calcular(100.0);
		}
	}
	
	
	
	
	
	
	
}
