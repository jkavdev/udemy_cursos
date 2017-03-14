package br.com.jkavdev.udemy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import br.com.jkavdev.udemy.config.ServiceConfig;
import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.impl.BlogPostServiceImpl;
import br.com.jkavdev.udemy.spring.service.impl.MediumBlogPostServiceImpl;
import br.com.jkavdev.udemy.spring.service.impl.WordPressBlogPostServiceImpl;

//Informando qual pacotes esta classe ira escanear
@ComponentScan(basePackages = { "br.com.jkavdev.udemy.spring" })
// Importando recursos ao spring, não contidos no ComponentScan
@Import(value = { ServiceConfig.class })
public class JavaConfig {

	// Criara um bean com o nome do metodo, sendo gerenciado pelo spring
	@Bean
	// Priorizando este bean
	@Primary
	public BlogPostService blogPostService() {
		return new BlogPostServiceImpl();
	}

	@Bean(name = "wordPressblogPostService")
	public BlogPostService wordPressBlogPostService() {
		return new WordPressBlogPostServiceImpl();
	}

	@Bean(name = "mediumBlogPostService")
	public BlogPostService mediumblogPostService() {
		return new MediumBlogPostServiceImpl();
	}
}
