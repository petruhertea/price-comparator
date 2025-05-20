package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.DiscountRepository;
import com.petruth.price_comparator_market.entity.Discount;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository){
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public List<Discount> findAllByOrderByPercentageDiscountDesc() {
        return discountRepository.findAllByOrderByPercentageDiscountDesc();
    }

    @Override
    public List<Discount> findByFromDateAfter(LocalDate date) {
        return discountRepository.findByFromDateAfter(date);
    }

    @Override
    public List<Discount> findByFromDateAfterOrderByPercentageDiscountDesc(LocalDate date) {
        return discountRepository.findByFromDateAfterOrderByPercentageDiscountDesc(date);
    }
}
