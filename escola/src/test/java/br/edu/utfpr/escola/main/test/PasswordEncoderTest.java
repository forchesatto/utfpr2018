package br.edu.utfpr.escola.main.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.utfpr.escola.MainEscola;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MainEscola.class)
public class PasswordEncoderTest {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void gerarSenha(){
		System.out.println(passwordEncoder.encode("123456"));
	}
	
	
	
	
	
}
