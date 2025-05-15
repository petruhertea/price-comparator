package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
