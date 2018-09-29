package br.edu.utfpr.spring.regras;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("impostoSC")
@Primary
public class CalculadoraImpostoSC implements CalculadoraImposto {

	@Override
	public Double calcular(Double valorCompra) {
		return valorCompra * 0.30;
	}

}
