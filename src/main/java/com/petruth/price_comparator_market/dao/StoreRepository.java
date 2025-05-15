package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
