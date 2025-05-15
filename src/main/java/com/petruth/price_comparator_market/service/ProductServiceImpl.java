package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.ProductRepository;
import com.petruth.price_comparator_market.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
