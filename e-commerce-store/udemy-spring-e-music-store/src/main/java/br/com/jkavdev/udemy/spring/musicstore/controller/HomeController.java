package br.com.jkavdev.udemy.spring.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.udemy.spring.musicstore.dao.ProductDao;
import br.com.jkavdev.udemy.spring.musicstore.model.Product;

@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model) {
		model.addAttribute("products", productDao.getAllProducts());

		return "product-list";
	}

	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable Long productId, Model model) {
		Product product = productDao.getProductById(productId);
		model.addAttribute("product", product);

		return "view-product";
	}

}
