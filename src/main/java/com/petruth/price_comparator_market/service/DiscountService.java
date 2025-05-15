package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.entity.Discount;

import java.time.LocalDate;
import java.util.List;

public interface DiscountService {
    List<Discount> findAll();
    List<Discount> findAllByOrderByPercentagediscountDesc();
    List<Discount> findByFromDateAfter(LocalDate date);
}
