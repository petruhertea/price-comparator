package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.entity.BasketItem;
import com.petruth.price_comparator_market.entity.BestOptions;

import java.util.List;

public interface BasketService {
    List<BestOptions> findBestOptions(List<BasketItem> items);
}
