package br.edu.utfpr.escola;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate> {
	
	private final String PATTERN = "dd/MM/yyyy";

	@Override
	public String print(LocalDate data, Locale locale) {
		if(data == null){
			return null;
		}
		return data.format(DateTimeFormatter.ofPattern(PATTERN));
	}

	@Override
	public LocalDate parse(String data, Locale locale) throws ParseException {
		if(data == null){
			return null;
		}
		return LocalDate.parse(data);
	}

}
