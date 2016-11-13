package com.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String redirectHome(){
		return "home";
	}
	@RequestMapping("/productList")
	public String listProduct(Model model){
		return "productList";
	}
	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId ,Model model){
		return "listProducts";
	}
}
