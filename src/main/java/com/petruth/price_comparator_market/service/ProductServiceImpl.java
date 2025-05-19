package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.ProductRepository;
import com.petruth.price_comparator_market.entity.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.util.DiscountHelper;
import com.petruth.price_comparator_market.util.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DiscountHelper discountHelper;

    public ProductServiceImpl(ProductRepository productRepository,
                              DiscountHelper discountHelper) {
        this.productRepository = productRepository;
        this.discountHelper = discountHelper;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<PriceHistory> filterProductHistory(String productId, Optional<String> store, Optional<String> category, Optional<String> brand) {
        List<Product> products = productRepository.findByProductIdOrderByPriceDateAsc(productId);

        return products.stream()
                .filter(p -> store.map(s -> s.equalsIgnoreCase(p.getStore().getName())).orElse(true))
                .filter(p -> category.map(c -> c.equalsIgnoreCase(p.getProductCategory())).orElse(true))
                .filter(p -> brand.map(b -> b.equalsIgnoreCase(p.getBrand())).orElse(true))
                .map(p -> {
                    double discountedPrice = discountHelper.calculateDiscount(p);
                    return ProductMapper.toPriceHistory(p, discountedPrice);
                })
                .toList();
    }
}
