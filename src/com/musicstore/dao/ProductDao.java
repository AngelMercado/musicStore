package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Product;

public interface ProductDao {
	void addProduct(Product product);
	Product getProductById(int id);
	List<Product> getallProducts();
	void deleteProduct(int id);
	void editProduct(Product product);

}
