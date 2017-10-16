package br.com.jkavdev.udemy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//Anotacao que indica para o spring boot iniciar todo o seu contexto
@SpringBootApplication
// SpringBootServletInitializer podemos alterar o comportamento padrao
// dos servlet, que no caso iremos alterar o servidor, utilizando o wildfly
public class Main extends SpringBootServletInitializer {

	// Inicializa o contexto
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	// Para indicar alteracao no servidor, precisamos reescrever o metodo configure
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(getClass());
	}

}
