package com.example.hicardi.domain.product.repository;

import com.example.hicardi.domain.product.entity.DemoProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoProductRepository extends JpaRepository<DemoProduct, Long> {
}
