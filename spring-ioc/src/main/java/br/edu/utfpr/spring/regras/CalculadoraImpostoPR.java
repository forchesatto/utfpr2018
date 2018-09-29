package br.edu.utfpr.spring.regras;

import org.springframework.stereotype.Service;

@Service("impostoPR")
public class CalculadoraImpostoPR implements CalculadoraImposto{

	@Override
	public Double calcular(Double valorCompra) {
		return valorCompra * 0.35;
	}

}
