package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductId(String productId);
    List<Product> findByProductIdOrderByPriceDateAsc(String productId);
}
