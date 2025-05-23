package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dto.BestOptions;
import com.petruth.price_comparator_market.dto.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean existsByProductId(String productId);
    List<Product> findAll();
    List<PriceHistory> filterProductHistory(String productId, Optional<String> store,
                                            Optional<String> category, Optional<String> brand);
    List<BestOptions> getRecommendations(String productId);
}
