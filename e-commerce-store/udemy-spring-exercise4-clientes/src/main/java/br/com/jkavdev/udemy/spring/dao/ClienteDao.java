package br.com.jkavdev.udemy.spring.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.udemy.spring.model.Cliente;

public class ClienteDao {

	public List<Cliente> getClientes() {

		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(criaCliente("Jhonatan", 25));
		clientes.add(criaCliente("Lucas", 21));
		clientes.add(criaCliente("Douglas", 22));
		clientes.add(criaCliente("Maria", 21));
		clientes.add(criaCliente("Mairo", 26));

		return clientes;
	}

	public Cliente criaCliente(String nome, int idade) {
		Cliente cliente = new Cliente();
		cliente.setIdade(idade);
		cliente.setNome(nome);

		return cliente;
	}

}
