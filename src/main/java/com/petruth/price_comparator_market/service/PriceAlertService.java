package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.entity.PriceAlert;

import java.util.List;

public interface PriceAlertService {
    List<PriceAlert> findAllByUser(String userId);
    PriceAlert createAlert(PriceAlert alert);
    PriceAlert findById(Long alertId);
    void deleteAlert(Long alertId);
    List<PriceAlert> checkAlerts(String productId, double currentPrice);
}
