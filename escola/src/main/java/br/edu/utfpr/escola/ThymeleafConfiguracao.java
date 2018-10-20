package br.edu.utfpr.escola;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ThymeleafConfiguracao implements WebMvcConfigurer{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		WebMvcConfigurer.super.addFormatters(registry);
		//registry.addConverter(new LocalDateConverter());
		
		registry.addFormatter(new LocalDateFormatter());
	}
	
	
	
	
	
	
	
	
	
	
	
}
