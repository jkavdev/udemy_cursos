package br.com.jkavdev.udemy.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.jkavdev.udemy.spring.service.EmailService;

public class EmailServiceImpl implements EmailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

	@Override
	public void sendEmail() {
		LOGGER.debug("Enviar email chamado.......");
	}

}
