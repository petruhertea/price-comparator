package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.ProductRepository;
import com.petruth.price_comparator_market.dto.BestOptions;
import com.petruth.price_comparator_market.dto.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.util.BestOptionsMapper;
import com.petruth.price_comparator_market.util.DiscountHelper;
import com.petruth.price_comparator_market.util.ProductMapper;
import com.petruth.price_comparator_market.util.UnitConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public boolean existsByProductId(String productId) {
        boolean productExists = productRepository.existsByProductId(productId);
        if (!productExists) {
            throw new RuntimeException("Could not find the product with id - " + productId);
        }
        return productExists;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<PriceHistory> filterProductHistory(String productId, Optional<String> store, Optional<String> category, Optional<String> brand) {
        List<Product> products;

        if (!productRepository.existsByProductId(productId)) {
            throw new RuntimeException("Could not find the product with id - " + productId);
        } else {
            products = productRepository.findByProductIdOrderByPriceDateAsc(productId);
        }

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

    @Override
    public List<BestOptions> getRecommendations(String productId) {

        Product reference;

        if (!productRepository.existsByProductId(productId)) {
            throw new RuntimeException("Could not find the product with id - " + productId);
        } else {
            reference = productRepository.findFirstByProductId(productId);
        }

        if (reference == null) return List.of();

        List<BestOptions> bestOptionsList = new ArrayList<>();

        List<Product> similarProducts = productRepository.findByProductCategoryAndProductIdNot(
                reference.getProductCategory(),
                productId
        );

        similarProducts.sort(Comparator.comparingDouble(product -> {
            double finalPrice = discountHelper.calculateDiscount(product);
            return UnitConverter.computePricePerStandardUnit(finalPrice,
                    product.getPackageQuantity(), product.getPackageUnit());
        }));

        for (Product similarProduct : similarProducts) {
            BestOptions bestOptions = BestOptionsMapper.from(similarProduct, discountHelper);
            bestOptions.setTotalPrice(null);
            bestOptionsList.add(bestOptions);
        }

        return bestOptionsList;
    }
}
