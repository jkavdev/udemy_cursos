package br.com.jkavdev.udemy.spring.musicstore.dao;

import java.util.List;

import br.com.jkavdev.udemy.spring.musicstore.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	Product getProductById(Long id);
	List<Product> getAllProducts();
	void deleteProduct(Long id);

}
