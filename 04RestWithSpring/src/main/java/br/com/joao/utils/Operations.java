package br.com.joao.utils;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.joao.exception.UnsuportedMathOperationException;

public class Operations {
	// Response do servidor fica dentro deste método
	public static boolean isNumber(String number) {
		try {
			Double.parseDouble(number);
			return true;
		}catch(java.lang.NumberFormatException ex) {
			return false;
		}
	}
}
