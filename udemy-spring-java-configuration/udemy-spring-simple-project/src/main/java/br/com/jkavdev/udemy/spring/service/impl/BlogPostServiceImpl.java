package br.com.jkavdev.udemy.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.udemy.spring.domain.BlogPost;
import br.com.jkavdev.udemy.spring.domain.DataSource;
import br.com.jkavdev.udemy.spring.service.BlogPostService;
import br.com.jkavdev.udemy.spring.service.EmailService;

public class BlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

	// Injetando objetos com autowired
	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmailService emailService;

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("Enviando email: " + emailService);
		LOGGER.debug("URL datasource: " + dataSource.getUrl());
		LOGGER.debug("salvar blog chamado.......");
	}

}
