package br.com.jkavdev.udemy.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.udemy.springboot.models.Usuario;
import br.com.jkavdev.udemy.springboot.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/usuarios")
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/usuarios")
	public Usuario alterarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/usuarios/{id}")
	public void alterarUsuario(@PathVariable String id) {
		usuarioRepository.delete(id);
	}

}
