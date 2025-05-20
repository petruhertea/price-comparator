package com.petruth.price_comparator_market.util;

import com.petruth.price_comparator_market.dto.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;

public class ProductMapper {
    public static PriceHistory toPriceHistory(Product product, double priceDiscounted) {
        PriceHistory history = new PriceHistory(
                product.getProductId(),
                product.getProductName(),
                product.getStore().getName(),
                product.getBrand(),
                product.getProductCategory(),
                product.getPrice(),
                product.getPriceDate()
        );
        history.setDiscountedPrice(priceDiscounted);
        return history;
    }
}
