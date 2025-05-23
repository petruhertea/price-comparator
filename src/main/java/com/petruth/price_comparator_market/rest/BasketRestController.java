package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.dto.BasketItem;
import com.petruth.price_comparator_market.dto.StoreBasket;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.service.BasketService;
import com.petruth.price_comparator_market.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BasketRestController {

    public final BasketService basketService;
    public final ProductService productService;

    public BasketRestController(BasketService basketService, ProductService productService){
        this.basketService = basketService;
        this.productService = productService;
    }

    @PostMapping("/basket/best-deals")
    public List<StoreBasket> getBestDeals(@RequestBody @Valid List<BasketItem> items){
        if (items.isEmpty()) {
            throw new RuntimeException("The basket is empty. Please fill the basket");
        }

        return basketService.optimizeShoppingBasket(items);
    }
}
