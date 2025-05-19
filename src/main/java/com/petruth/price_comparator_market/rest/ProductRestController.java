package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.entity.PriceHistory;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    private List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/products/{productId}/history")
    private List<PriceHistory> getProducts(
            @PathVariable String productId,
            @RequestParam Optional<String> store,
            @RequestParam Optional<String> category,
            @RequestParam Optional<String> brand){

        return productService.filterProductHistory(productId,store,category,brand);
    }
}
