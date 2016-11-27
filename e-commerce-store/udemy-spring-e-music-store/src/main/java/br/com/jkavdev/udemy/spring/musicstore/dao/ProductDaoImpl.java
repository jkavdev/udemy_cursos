package br.com.jkavdev.udemy.spring.musicstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.udemy.spring.musicstore.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public Product getProductById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Product) session.get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();
	}

	@Override
	public void deleteProduct(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(id);
		session.flush();
	}

}
