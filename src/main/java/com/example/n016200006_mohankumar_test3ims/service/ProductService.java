package com.example.n016200006_mohankumar_test3ims.service;

import com.example.n016200006_mohankumar_test3ims.model.Product;
import com.example.n016200006_mohankumar_test3ims.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    
    public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
    
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void updateProduct(Product product) {
		
		Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
		
		if(existingProduct != null) {
			existingProduct.setProductName(product.getProductName());
			existingProduct.setProductDescription(product.getProductDescription());
			existingProduct.setProductPrice(product.getProductPrice());
			existingProduct.setProductStock(product.getProductStock());
			productRepository.save(existingProduct);
		}
		
	}
	
	public void updateStock(Product product) {
Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
		
		if(existingProduct != null) {
			existingProduct.setProductName(product.getProductName());
			existingProduct.setProductDescription(product.getProductDescription());
			existingProduct.setProductPrice(product.getProductPrice());
			existingProduct.setProductStock(product.getProductStock());
			productRepository.save(existingProduct);
		}
	}
}
