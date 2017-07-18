
package com.primeStore.musicStore.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primeStore.musicStore.dao.ProductDao;
import com.primeStore.musicStore.domain.Product;
import java.io.File;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class IndexController {
	
    @Autowired
	ProductDao productDao;
    private Path path;
    private static final Logger logger= Logger.getLogger(IndexController.class);
	@RequestMapping(value="/")
	public String test(Model model) {	
		return "index";
	}
	@RequestMapping(value="/productList")
	public String getProductList(Model model){
		List<Product> productList=productDao.getProductList();
		Product product = productList.get(0);
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
	@RequestMapping(value="/test")
	public String test(){
		return "test";
	}
	@RequestMapping(value="/admin/productInventory")
	public String productInventoryPage(Model model){
		List<Product> productList=productDao.getProductList();
		model.addAttribute("products",productList);
		return "inventory";
	}
	@RequestMapping(value="/admin/productInventory/addProduct")
	public String addProduct(Model model){
		logger.info("////////////////////////////////----Trying to save object");
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product",product);
		return "addProd";
	}
	@RequestMapping(value="/admin/productInventory/addProduct" ,method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product")Product product,HttpServletRequest request){
		logger.info("////////////////////////////////----Trying to save object");
		productDao.addProduct(product);
		logger.error("Trying to save object");
                MultipartFile productImage= product.getProductImage();
                String rootDirectory = request.getSession().getServletContext().getRealPath("/");
                path = Paths.get(rootDirectory+ "\\resources\\images" +product.getIdProduct()+".png");
		if(productImage!= null && !productImage.isEmpty()){
                    try {
                        productImage.transferTo(new File(path.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("Product Image saving fail "+e);
                        throw new RuntimeException("Product Image saving failed"+e);
                    }
                }
                return "redirect:/admin/productInventory";
	}
//	@RequestMapping(value="/admin/productInventory/updateProduct")
//	public String editProduct(){
//		return "updateProduct";
//	}
	@RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId){		
		productDao.deleteProduct(productId);                
		return "redirect:/admin/productInventory";
	}
	
}