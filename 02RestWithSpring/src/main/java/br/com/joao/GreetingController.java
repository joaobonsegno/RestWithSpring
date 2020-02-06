package br.com.joao;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	//private static final String template = "Hello, %s";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") //Definição da rota
	// Response do servidor fica dentro deste método
	public Greeting getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		// Os parâmetros da requisição ficam na annotation "@RequestParam"
		// O atributo "value" define qual será o nome do parâmetro na URL
		return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", name));
	}
}
