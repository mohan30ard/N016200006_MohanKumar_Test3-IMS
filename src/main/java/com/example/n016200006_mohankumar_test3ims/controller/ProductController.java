package com.example.n016200006_mohankumar_test3ims.controller;

import com.example.n016200006_mohankumar_test3ims.model.Product;
import com.example.n016200006_mohankumar_test3ims.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showIndexPage(Model model) {
        // Provide a fresh Student object for registration
        model.addAttribute("Product", new Product());
        return "index"; // index.html
    }
    
    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
    
    @GetMapping("/products/id")
    public Product getProductById(@RequestBody Long id) {
    	return productService.getProductById(id);
    }
    
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
    Product existingProduct = productService.getProductById(product.getProductId());
    if(existingProduct != null) {
    				productService.updateProduct(product);
				} else {
					productService.addProduct(product);
				}
    }
    
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
    			productService.updateProduct(product);
    }
    
    @DeleteMapping("/products")
    public void deleteProduct(@RequestBody Long id) {
				productService.deleteProduct(id);
	}
    
    @PutMapping("/products/stock")
	public void updateStock(@RequestBody Product product) {
				productService.updateStock(product);
	}
    
    
}
