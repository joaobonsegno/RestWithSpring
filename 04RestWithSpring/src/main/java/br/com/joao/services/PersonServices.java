package br.com.joao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.exception.ResourceNotFoundException;
import br.com.joao.model.Person;
import br.com.joao.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository; 
	
	public Person create(Person p) {
		return repository.save(p);
	} 
	
	public List<Person> findAll(){
		return repository.findAll();
	}

	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public Person update(Person p) {
		Person entity = repository.findById(p.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(p.getFirstName());
		entity.setLastName(p.getLastName());
		entity.setGender(p.getGender());
		entity.setAge(p.getAge());
		entity.setAdress(p.getAdress());
	
		return repository.save(entity); 
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	//-Dserver.port=8090
}
