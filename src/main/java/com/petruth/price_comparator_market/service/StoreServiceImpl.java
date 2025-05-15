package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.StoreRepository;
import com.petruth.price_comparator_market.entity.Store;

import java.util.List;

public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
