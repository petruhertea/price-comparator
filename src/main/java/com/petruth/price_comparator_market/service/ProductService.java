package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.entity.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    List<PriceHistory> filterProductHistory(String productId, Optional<String> store,
                                            Optional<String> category, Optional<String> brand);
}
