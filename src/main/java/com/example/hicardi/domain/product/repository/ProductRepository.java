package com.example.hicardi.domain.product.repository;

import com.example.hicardi.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product findProductById(Long id);

    List<Product> findByTitleContaining(String name);

}
