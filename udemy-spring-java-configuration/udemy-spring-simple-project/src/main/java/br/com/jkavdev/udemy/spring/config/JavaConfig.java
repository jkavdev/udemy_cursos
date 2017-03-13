package br.com.jkavdev.udemy.spring.config;

import org.springframework.context.annotation.Bean;

import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.impl.BlogPostServiceImpl;

public class JavaConfig {

	// Criara um bean com o nome do metodo, sendo gerenciado pelo spring 
	@Bean
	public BlogPostService blogPostService() {
		return new BlogPostServiceImpl();
	}

}
