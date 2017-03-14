package br.com.jkavdev.udemy.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.jkavdev.udemy.spring.domain.BlogPost;
import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager{
	
	//Injetando objeto com qualificador
	@Autowired
	@Qualifier("mediumBlogPostService")
	private BlogPostService blogPostService;

	@Override
	public void sendBlogPost(BlogPost blogPost) {
		blogPostService.savePost(blogPost);
	}

}
