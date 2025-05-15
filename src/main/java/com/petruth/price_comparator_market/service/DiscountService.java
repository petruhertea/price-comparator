package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.entity.Discount;

import java.util.List;

public interface DiscountService {
    List<Discount> findAll();
}
