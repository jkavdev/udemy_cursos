			package br.com.jkavdev.udemy.springboot.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.udemy.springboot.models.Usuario;

@RestController
public class IndexController {

	@GetMapping
	public String index() {
		return "Tá funcionando......";
	}

	@GetMapping("/nome/{nome}")
	public String index(@PathVariable String nome) {
		return "Tá funcionando...... " + nome;
	}

	@PostMapping("/usuario/")
	public Usuario index(@RequestBody Usuario usuario) {
		System.out.println("Tá funcionando...... " + usuario.getNome());
		return usuario;
	}

	@PutMapping("/usuario/")
	public Usuario indexPut(@RequestBody Usuario usuario) {
		System.out.println("Tá funcionando...... " + usuario.getNome());
		return usuario;
	}

	@DeleteMapping("/usuario/")
	public Usuario indexDelete(@RequestBody Usuario usuario) {
		System.out.println("Tá funcionando...... " + usuario.getNome());
		return usuario;
	}

}
