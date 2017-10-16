package br.com.jkavdev.udemy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Anotacao que indica para o spring boot iniciar todo o seu contexto
@SpringBootApplication
public class Main {

	//Inicializa o contexto
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

}
