package com.musicstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;	
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);		
		return product;
	}

	@Override
	public List<Product> getallProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product"); 
		List<Product> products = query.list();
		return products;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.getProductById(id));
		
	}

}
