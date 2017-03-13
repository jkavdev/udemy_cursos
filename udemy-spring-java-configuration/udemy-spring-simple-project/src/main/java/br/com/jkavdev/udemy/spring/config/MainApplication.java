package br.com.jkavdev.udemy.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.jkavdev.udemy.spring.domain.BlogPost;
import br.com.jkavdev.udemy.spring.domain.DataSource;
import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.impl.BlogPostServiceImpl;

public class MainApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

	public static void main(String[] args) {
		// Contexto do spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		// Recebendo bean criado pelo nome da classe
		BlogPostService postServiceClassName = context.getBean(BlogPostService.class);

		// Recebendo bean criado pelo nome do metodo
		BlogPostService postServiceMethodName = (BlogPostService) context.getBean("blogPostService");

		BlogPost blogPost = new BlogPost();
		blogPost.setId(1L);
		blogPost.setTitle("Java config project");

		postServiceClassName.savePost(blogPost);
		postServiceMethodName.savePost(blogPost);

		DataSource dataSource = context.getBean(DataSource.class);
		LOGGER.debug("datasource url: " + dataSource.getUrl());
		LOGGER.debug("datasource senha: " + dataSource.getPassword());
		LOGGER.debug("datasource usuario: " + dataSource.getUsername());

		// Fechando contexto do spring
		((ConfigurableApplicationContext) context).close();
	}

}
