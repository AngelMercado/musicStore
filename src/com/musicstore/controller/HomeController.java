package com.musicstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;

@Controller
public class HomeController {
	
	private Path path;
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
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getallProducts();
		model.addAttribute("products",products);
		return "productInventory";
	}
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product",product);
		return "addProduct";
	}
	@RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product,HttpServletRequest request){
		MultipartFile productImage = product.getProductImage();
		System.out.println(productImage.getOriginalFilename());
		productDao.addProduct(product);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images" +product.getProductId()+".png");
		System.out.println(path);
		if(productImage!=null && !productImage.isEmpty()){
			try {
				productImage.transferTo(new File(path.toString()));
				System.out.println("la imagen se a guardado");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				throw new RuntimeException("Product Image Serving failed",e);
				
			}
		}else{
			System.out.println("vacio");
		}
		return "redirect:/admin/productInventory";
	}
	@RequestMapping("admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id,Model model){
		productDao.deleteProduct(id);
		return "redirect:/admin/productInventory";
	}
}
