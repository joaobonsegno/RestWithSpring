package br.com.joao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.exception.UnsuportedMathOperationException;
import br.com.joao.utils.Operations;

@RestController
public class MathController {
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method=RequestMethod.GET) //Definição da rota
	// Response do servidor fica dentro deste método
	public Double sum(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		// Os parâmetros da requisição ficam na annotation "@RequestParam"
		// O atributo "value" define qual será o nome do parâmetro na URL
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
			return sum;
		} 
	}
	
	@RequestMapping(value="sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
			return sum;
		}
	}
	
    @RequestMapping(value="div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
			return sum;
		}
	}
	
	@RequestMapping(value="mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
			return sum;
		}
	}
	
	@RequestMapping(value="pow/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double pow(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Math.pow(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
			return sum;
		}
	}
	
	@RequestMapping(value="sqrt/{numberOne}", method=RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		// Os parâmetros da requisição ficam na annotation "@RequestParam"
		// O atributo "value" define qual será o nome do parâmetro na URL
		if (!Operations.isNumber(numberOne)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = Math.sqrt(Double.parseDouble(numberOne));
			return sum;
		}
	}
	
	@RequestMapping(value="avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double avg(		
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Operations.isNumber(numberOne) || !Operations.isNumber(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, set a numeric value");
		}else {
			Double sum = (Double.parseDouble(numberOne) + Double.parseDouble(numberOne)) / 2;
			return sum;
		}
	}
}
