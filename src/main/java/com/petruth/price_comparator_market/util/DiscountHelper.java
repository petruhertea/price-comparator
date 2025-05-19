package com.petruth.price_comparator_market.util;

import com.petruth.price_comparator_market.dao.DiscountRepository;
import com.petruth.price_comparator_market.entity.Discount;
import com.petruth.price_comparator_market.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class DiscountHelper {
    private final DiscountRepository discountRepository;

    public DiscountHelper(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }
    // Calculate discounted price where the discount is available, otherwise use the original price
    public double calculateDiscount(Product product) {
        List<Discount> discounts = discountRepository
                .findByProductIdAndToDateAfter(product.getProductId(), LocalDate.now());

        return discounts.stream()
                .max(Comparator.comparing(Discount::getPercentageDiscount))
                .map(d -> product.getPrice() * (1 - d.getPercentageDiscount() / 100.0))
                .orElse(product.getPrice());
    }

    public double getOriginalPrice(Product product) {
        return product.getPrice();
    }
}
