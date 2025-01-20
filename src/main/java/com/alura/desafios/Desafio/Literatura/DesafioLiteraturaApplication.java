package com.alura.desafios.Desafio.Literatura;

import com.alura.desafios.Desafio.Literatura.principal.Principal;
import com.alura.desafios.Desafio.Literatura.repository.AutorRepository;
import com.alura.desafios.Desafio.Literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiteraturaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(DesafioLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal p = new Principal(libroRepository,autorRepository);
		p.menuPrincipal();

	}
}
