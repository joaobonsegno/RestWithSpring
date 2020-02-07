package br.com.joao.services;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.joao.model.Person;

@Service
public class PersonServices {
	//o CRUD da classe Person fica aqui!
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person p) {
		return p;
	}
	
	public Person update(Person p) {
		return p;
	}
	
	public String delete(int id) {
		return "Pessoa deletada com sucesso";
	}
	
	public Person findById(String id) {
		Person p = new Person();
		p.setFirstName("Joao");
		p.setLastName("Bonsegno");
		p.setGender("Male");
		p.setAge(20);
		p.setId(counter.incrementAndGet());
		p.setAdress("Av Los Alamos, 505 - Vargem Grande Pta, SP");
		return p;
	}
	
	public ArrayList<Person> findAll(){
		ArrayList<Person> people = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person p = mockPerson(i);
			people.add(p);
		}
		return people;
	}
	
	private Person mockPerson(int id) {
		Person p = new Person();
		p.setFirstName("Name: "+id);
		p.setLastName("Last Name: "+id);
		p.setGender("Gender: "+id);
		p.setAge(20);
		p.setId(counter.incrementAndGet());
		p.setAdress("Any adress in Brazil");
		return p;
		
	}
	
}
