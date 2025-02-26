package com.example.n016200006_mohankumar_test3ims.controller;

import com.example.n016200006_mohankumar_test3ims.model.Product;
import com.example.n016200006_mohankumar_test3ims.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("listProducts", products);
        return "index";
    }

    @GetMapping("/product/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute("product") @Validated Product product, RedirectAttributes redirectAttrs) {
        productService.saveProduct(product);
        redirectAttrs.addFlashAttribute("successMessage", "Product saved successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        return productService.getProductById(id).map(product -> {
            model.addAttribute("product", product);
            return "update_product";
        }).orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") @Validated Product product, RedirectAttributes redirectAttrs) {
        productService.updateProduct(product);
        redirectAttrs.addFlashAttribute("successMessage", "Product updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        productService.deleteProduct(id);
        redirectAttrs.addFlashAttribute("successMessage", "Product deleted successfully!");
        return "redirect:/";
    }
}
