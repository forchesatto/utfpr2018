package br.edu.utfpr.escola;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class LocalDateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		if(StringUtils.isEmpty(source)){
			return null;
		}
		return LocalDate.parse(source);
	}
	
	
	
	
	
	
	
	
	

}
