package com.example.demo.ProductStuff.Repository;

import com.example.demo.ProductStuff.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
