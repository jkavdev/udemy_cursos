package br.com.jkavdev.udemy.spring.musicstore.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.udemy.spring.musicstore.model.Product;

public class ProductDao {

	private List<Product> productList;

	public List<Product> getProductList() {
		Product product = new Product();

		product.setProductName("Guitar");
		product.setProductCategory("Instrument");
		product.setProductDescription("This is a guitar");
		product.setProductPrice(1200);
		product.setProductCondition("new");
		product.setProductStatus("Active");
		product.setProductStock(11);
		product.setProductManufacturer("Fender");

		productList = new ArrayList<>();
		productList.add(product);

		return productList;
	}

}
