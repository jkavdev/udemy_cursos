package br.com.jkavdev.udemy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.udemy.spring.dao.ClienteDao;

@Controller
public class ClientesController {

	@RequestMapping("/")
	public String clientes(Model model) {
		model.addAttribute("clientes", new ClienteDao().getClientes());

		return "clientes";
	}

}
