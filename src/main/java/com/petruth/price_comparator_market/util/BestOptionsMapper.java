package com.petruth.price_comparator_market.util;

import com.petruth.price_comparator_market.dto.BestOptions;
import com.petruth.price_comparator_market.entity.Product;

public class BestOptionsMapper {
    public static BestOptions from(Product product, DiscountHelper discountHelper) {
        double originalPrice = discountHelper.getOriginalPrice(product);
        double discountedPrice = discountHelper.calculateDiscount(product);
        double quantity = product.getPackageQuantity();

        BestOptions options = new BestOptions();
        options.setProductName(product.getProductName());
        options.setBrand(product.getBrand());
        options.setStoreName(product.getStore().getName());
        options.setCategory(product.getProductCategory());
        options.setOriginalPrice(originalPrice);
        options.setDiscountedPrice(discountedPrice);
        options.setPackageQuantity(quantity);
        options.setPackageUnit(product.getPackageUnit());
        options.setPricePerUnit(UnitConverter.formatPricePerStandardUnit(
                discountedPrice, quantity, product.getPackageUnit(), product.getCurrency()
        ));

        return options;
    }
}
