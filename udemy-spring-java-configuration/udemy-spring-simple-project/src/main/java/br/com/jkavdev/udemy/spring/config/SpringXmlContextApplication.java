package br.com.jkavdev.udemy.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.jkavdev.udemy.spring.domain.DataSource;
import br.com.jkavdev.udemy.spring.service.impl.BlogPostServiceImpl;

public class SpringXmlContextApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

	public static void main(String[] args) {

		// Criando contexto do spring a partir do arquivo xml
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		DataSource dataSource = context.getBean(DataSource.class);

		LOGGER.debug("Spring xml: " + dataSource.getUrl());
		LOGGER.debug("Spring xml: " + dataSource.getUsername());

		((ConfigurableApplicationContext) context).close();

	}

}
