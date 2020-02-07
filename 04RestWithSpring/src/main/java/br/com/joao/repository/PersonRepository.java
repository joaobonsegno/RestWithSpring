package br.com.joao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
