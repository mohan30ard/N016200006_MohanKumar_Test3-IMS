package com.example.n016200006_mohankumar_test3ims.controller;

import com.example.n016200006_mohankumar_test3ims.model.Product;
import com.example.n016200006_mohankumar_test3ims.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showIndexPage(Model model) {
    	model.addAttribute("listProducts", productService.getAllProducts());
        return "index"; // Assumes index.html exists in the template directory
    }
    
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
    
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }
    
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        this.productService.deleteProduct(id);
        return "redirect:/";
    }

}
