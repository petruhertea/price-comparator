package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.DiscountRepository;
import com.petruth.price_comparator_market.dao.ProductRepository;
import com.petruth.price_comparator_market.entity.BasketItem;
import com.petruth.price_comparator_market.entity.BestOptions;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.util.DiscountHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService{

    public final ProductRepository productRepository;
    public final DiscountRepository discountRepository;
    public final DiscountHelper discountHelper;

    public BasketServiceImpl(ProductRepository productRepository,
                             DiscountRepository discountRepository,
                             DiscountHelper discountHelper){
        this.productRepository = productRepository;
        this.discountRepository = discountRepository;
        this.discountHelper = discountHelper;
    }

    @Override
    public List<BestOptions> findBestOptions(List<BasketItem> items) {
        List<BestOptions> bestOptionsList = new ArrayList<>();

        for (BasketItem item : items) {

            List<Product> products = productRepository.findByProductId(item.getProductId());

            if (products.isEmpty()) continue;

            Product bestOption = products.stream()
                    .min(Comparator.comparing(discountHelper::calculateDiscount))
                    .orElse(null);

            if (bestOption != null) {

                double originalPrice = discountHelper.getOriginalPrice(bestOption);
                double finalPrice = discountHelper.calculateDiscount(bestOption);

                BestOptions bestOptions = new BestOptions();
                bestOptions.setProductName(bestOption.getProductName());
                bestOptions.setStoreName(bestOption.getStore().getName());
                bestOptions.setOriginalPrice(originalPrice);
                bestOptions.setDiscountedPrice(finalPrice);
                bestOptions.setQuantity(item.getQuantity());
                bestOptions.setTotalPrice(finalPrice * item.getQuantity());
                bestOptionsList.add(bestOptions);
            }
        }

        return bestOptionsList;
    }
}
