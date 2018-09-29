package br.edu.utfpr.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.edu.utfpr.spring.regras.CalculadoraImposto;

// @SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	@Qualifier("impostoPR")
	private CalculadoraImposto calculadoraImposto;
	
	@Value("${uf}")
	private String uf;
	
	//Usado para encontrar beans
	@Autowired
	private ApplicationContext context;
	
	private CalculadoraImposto calculadoraImpostoDinamica;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("valor do imposto: "+uf+
					+calculadoraImposto.calcular(100.0));
		
		calculadoraImpostoDinamica = context
				.getBean(uf, CalculadoraImposto.class);
		
		System.out.println("valor do imposto dinamico:" 
		+calculadoraImpostoDinamica.calcular(100.0));
		
	}
	
	
	
	
	
	
	

}
