package br.com.jkavdev.udemy.spring.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productIventory(Model model) {
		model.addAttribute("products", productDao.getAllProducts());

		return "product-inventory";
	}

	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("New");
		product.setProductStatus("Active");
		model.addAttribute("product", product);

		return "add-product";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product){
		productDao.addProduct(product);
		
		return "redirect:/admin/productInventory";
	}

}
