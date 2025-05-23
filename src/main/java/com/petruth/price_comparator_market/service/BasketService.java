package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dto.BasketItem;
import com.petruth.price_comparator_market.dto.StoreBasket;

import java.util.List;

public interface BasketService {
    //method for optimizing basket across stores
    List<StoreBasket> optimizeShoppingBasket(List<BasketItem> items);
}
