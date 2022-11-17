package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.demo.beans.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
