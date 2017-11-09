package br.com.jkavdev.udemy.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

//Informando que este sera transformado para um documento no mongodb
@Document
/**
 * Interessante implementar o Serializable
 */
public @Data class Usuario extends BaseEntity{

	/**
	 * @Data do lombok: Já implementa os getters e setters, equals, e contrutores necessarios.
	 */

	/**
	 * 	definindo o identificador de cada registro usuario
	 */
	@Id
	/**
	 * Dependendo do caso é recomendável ignorar o ID do usuário por questões de segurança.
	 */
	@JsonIgnore
	private String id;

	private String nome;

}
