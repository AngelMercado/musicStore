
package com.primeStore.musicStore.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primeStore.musicStore.dao.ProductDao;
import com.primeStore.musicStore.domain.Product;

@Controller
public class IndexController {
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/")
	public String test(Model model) {	
		return "index";
	}
	@RequestMapping(value="/productList")
	public String getProductList(Model model){
		List<Product> productList=productDao.getProductList();
//		Product product = productList.get(0);
		model.addAttribute("products",productList);
		return "productList";
	}
	@RequestMapping(value="/productList/productDetail/{productId}")
	public String getProductDetail(@PathVariable String productId ,Model model){
		Product product;
		product = productDao.getProductByID(productId);
		model.addAttribute("product",product);
		
		return "productDetail";
	}
	@RequestMapping(value="/admin")
	public String adminPage(){
		return "admin";
	}
	@RequestMapping(value="/admin/productInventory")
	public String productInventoryPage(Model model){
		List<Product> productList=productDao.getProductList();
//		Product product = productList.get(0);
//		model.addAttribute("products",productList);
		return "productIventory";
	}
	@RequestMapping(value="/admin/productInvetory/addProduct")
	public String addProduct(){
		return "addProduct";
	}
	@RequestMapping(value="/admin/productInventory/updateProduct")
	public String editProduct(){
		return "updateProduct";
	}
	@RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId){		
		productDao.deleteProduct(productId);
		return "deleteProduct";
	}
	
}