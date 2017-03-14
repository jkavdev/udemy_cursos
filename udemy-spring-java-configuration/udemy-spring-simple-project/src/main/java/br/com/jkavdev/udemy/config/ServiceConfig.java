package br.com.jkavdev.udemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.udemy.spring.service.EmailService;
import br.com.jkavdev.udemy.spring.service.ServiceManager;
import br.com.jkavdev.udemy.spring.service.impl.EmailServiceImpl;
import br.com.jkavdev.udemy.spring.service.impl.ServiceManagerImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
	
	@Bean
	public ServiceManager serviceManager() {
		return new ServiceManagerImpl();
	}

}
