package br.com.joao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method=RequestMethod.GET) //Definição da rota
	// Response do servidor fica dentro deste método
	public Double sum(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		// Os parâmetros da requisição ficam na annotation "@RequestParam"
		// O atributo "value" define qual será o nome do parâmetro na URL
		if (!isNumber(numberOne) || !isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
			return sum;
		}
	}

	private boolean isNumber(String number) {
		try {
			Double.parseDouble(number);
			return true;
		}catch(java.lang.NumberFormatException ex) {
			return false;
		}
	}
	
}
