package com.petruth.price_comparator_market.dao;

import com.petruth.price_comparator_market.entity.PriceAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceAlertRepository extends JpaRepository<PriceAlert, Long> {
    List<PriceAlert> findByUserIdAndIsActiveTrue(String userId);
    List<PriceAlert> findByProductIdAndIsActiveTrue(String productId);
}
