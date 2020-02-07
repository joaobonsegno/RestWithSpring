package br.com.joao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;	

import br.com.joao.model.Person;
import br.com.joao.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@RequestMapping(method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person p){
		return services.create(p);
	}
		
	@RequestMapping(method=RequestMethod.PUT,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person p) {
		return services.update(p);
	}
	
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return services.findAll();
	}
	
	
	@RequestMapping(value="/{id}", 
				    method=RequestMethod.GET, 
				    produces=MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	
	 
	
	// Annotation: @RequestMapping
	// Rota: (value="/cadastro, method=RequestMethod.GET)
	// Método de response (tem retornar algo)
}
