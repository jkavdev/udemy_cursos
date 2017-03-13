package br.com.jkavdev.udemy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.udemy.spring.domain.DataSource;

@Configuration
public class DBConfig {

	//Retornando um datasource já criado
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl("url teste");
		dataSource.setPassword("senha teste");
		dataSource.setUsername("usuario teste");

		return dataSource;
	}

}
