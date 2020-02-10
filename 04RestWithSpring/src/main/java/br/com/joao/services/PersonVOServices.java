package br.com.joao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.converter.DozerConverter;
import br.com.joao.data.model.Person;
import br.com.joao.data.vo.PersonVO;
import br.com.joao.exception.ResourceNotFoundException;
import br.com.joao.repository.PersonRepository;

@Service
public class PersonVOServices {

	@Autowired
	PersonRepository repository; 
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	} 
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO personVo) {
		Person entity = repository.findById(personVo.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(personVo.getFirstName());
		entity.setLastName(personVo.getLastName());
		entity.setGender(personVo.getGender());
		entity.setAge(personVo.getAge());
		entity.setAdress(personVo.getAdress());
	
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class); 
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	//-Dserver.port=8090
}
