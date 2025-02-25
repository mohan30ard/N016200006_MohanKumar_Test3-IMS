package com.example.n016200006_mohankumar_test3ims.repository;


import com.example.n016200006_mohankumar_test3ims.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
