package br.com.jkavdev.udemy.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.jkavdev.udemy.springboot.models.Usuario;

//Extendendo interfaces do mongodb-pringdata que fornece operacoes com o documento definido
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
