package br.edu.utfpr.escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.utfpr.escola.service.UsuarioAutenticacaoService;


@EnableGlobalMethodSecurity(jsr250Enabled=true,prePostEnabled=true)
@EnableWebSecurity
public class SegurancaConfiguracao extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioAutenticacaoService usuarioAutenticacaoService;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login", "/login-error", "/css/**"
					, "/js/**", "/webjars/**").permitAll()
			
			.antMatchers("/aluno/**", "/").hasAnyRole("COORDENADOR"
					, "ALUNO", "ADMIN")
			.antMatchers("/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login")
				  .failureUrl("/login-error")
				  .defaultSuccessUrl("/");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(usuarioAutenticacaoService)
			.passwordEncoder(passwordEncoder());
	}
	
	
	
	
	
	
	
	
}
