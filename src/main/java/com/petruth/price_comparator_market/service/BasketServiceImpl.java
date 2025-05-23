package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.DiscountRepository;
import com.petruth.price_comparator_market.dao.ProductRepository;
import com.petruth.price_comparator_market.dto.BasketItem;
import com.petruth.price_comparator_market.dto.BestOptions;
import com.petruth.price_comparator_market.dto.StoreBasket;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.util.BestOptionsMapper;
import com.petruth.price_comparator_market.util.DiscountHelper;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public final ProductRepository productRepository;
    public final DiscountRepository discountRepository;
    public final DiscountHelper discountHelper;

    public BasketServiceImpl(ProductRepository productRepository,
                             DiscountRepository discountRepository,
                             DiscountHelper discountHelper) {
        this.productRepository = productRepository;
        this.discountRepository = discountRepository;
        this.discountHelper = discountHelper;
    }

    @Override
    public List<StoreBasket> optimizeShoppingBasket(List<BasketItem> items) {
        Map<String, List<BestOptions>> storeBaskets = new HashMap<>();

        List<Product> products;

        for (BasketItem item : items) {
            if (!productRepository.existsByProductId(item.getProductId())){
                throw new RuntimeException("Could not find the product with id - " + item.getProductId());
            }
            else {
                products = productRepository.findByProductId(item.getProductId());
            }

            // Find best store for this product
            Product bestProduct = products.stream()
                    .min(Comparator.comparing(discountHelper::calculateDiscount))
                    .orElse(null);

            if (bestProduct != null) {
                String storeName = bestProduct.getStore().getName();
                BestOptions option = BestOptionsMapper.from(bestProduct, discountHelper);
                option.setTotalPrice(item.getQuantity() * discountHelper.calculateDiscount(bestProduct));
                // Group by store
                storeBaskets.computeIfAbsent(storeName, k -> new ArrayList<>()).add(option);
            }
        }

        // Convert to StoreBasket list with totals for each store
        return storeBaskets.entrySet().stream()
                .map(entry -> {
                    double total = entry.getValue().stream()
                            .mapToDouble(BestOptions::getTotalPrice)
                            .sum();
                    return new StoreBasket(entry.getKey(), entry.getValue(), total);
                })
                .sorted(Comparator.comparing(StoreBasket::getStoreName))
                .collect(Collectors.toList());
    }
}
