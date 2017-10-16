package br.com.jkavdev.udemy.springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Informando que este sera transformado para um documento no mongodb
@Document
public class Usuario {

	//definindo o identificador de cada registro usuario
	@Id
	private String id;

	private String nome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
