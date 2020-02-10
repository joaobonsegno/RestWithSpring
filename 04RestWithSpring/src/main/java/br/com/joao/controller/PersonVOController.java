package br.com.joao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.data.vo.PersonVO;
import br.com.joao.services.PersonVOServices;

@RestController
@RequestMapping("/person")
public class PersonVOController {
	
	@Autowired
	private PersonVOServices services;
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO p){
		return services.create(p);
	}
		
	@PutMapping
	public PersonVO update(@RequestBody PersonVO p) {
		return services.update(p);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
	
	
	@GetMapping
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	
	 
	
	// Annotation: @RequestMapping
	// Rota: (value="/cadastro, method=RequestMethod.GET)
	// Método de response (tem retornar algo)
}
