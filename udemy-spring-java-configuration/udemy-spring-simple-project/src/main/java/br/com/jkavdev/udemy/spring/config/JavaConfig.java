package br.com.jkavdev.udemy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.impl.BlogPostServiceImpl;

//Informando qual pacotes esta classe ira escanear
@ComponentScan(basePackages = { "br.com.jkavdev.udemy.spring" })
public class JavaConfig {

	// Criara um bean com o nome do metodo, sendo gerenciado pelo spring
	@Bean
	public BlogPostService blogPostService() {
		return new BlogPostServiceImpl();
	}

}
