package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
