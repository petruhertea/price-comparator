package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
