package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.entity.Discount;
import com.petruth.price_comparator_market.service.DiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DiscountRestController {
    private final DiscountService discountService;

    public DiscountRestController(DiscountService discountService){
        this.discountService = discountService;
    }

    @GetMapping("/discounts")
    public List<Discount> getDiscount(){
        return discountService.findAll();
    }
}
