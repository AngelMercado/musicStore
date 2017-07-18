package com.primeStore.musicStore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.primeStore.musicStore.domain.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addProduct(Product product) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();		
	}

	@Override
	public Product getProductByID(String id) {
		Session session=sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, Integer.parseInt(id));
		session.flush();
		return product;
	}

	@Override
	public List<Product> getProductList() {
		Session session= sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Product");
		List<Product> productList= query.list();
		return productList;
	}

	@Override
	public void deleteProduct(String id) {
		
		Session session=sessionFactory.getCurrentSession();
		session.delete(getProductByID(id));
		session.flush();
	}
	
}
