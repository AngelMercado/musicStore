package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/")
	public String redirectHome(){
		return "home";
	}
	@RequestMapping("/productList")
	public String listProduct(Model model){
		List<Product> products =productDao.getallProducts();
		System.out.println(products);
		for (Product product : products) {
			 
			 System.out.println(product.getProductName());
			}
		model.addAttribute("products",products);
		return "productList";
	}
	@RequestMapping("productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId ,Model model){
		Product product = productDao.getProductById(productId);
		model.addAttribute("product",product);
		return "viewProduct";
	}
	@RequestMapping("/admin")
	public String adminPage(){
		
		return "admin";
	}
}
