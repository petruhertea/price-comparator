package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findAllByOrderByPercentageDiscountDesc();
    List<Discount> findByFromDateAfter(LocalDate date);
}
