package com.petruth.price_comparator_market.service;

import com.petruth.price_comparator_market.dao.PriceAlertRepository;
import com.petruth.price_comparator_market.entity.PriceAlert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceAlertServiceImpl implements PriceAlertService {

    private final PriceAlertRepository priceAlertRepository;

    public PriceAlertServiceImpl(PriceAlertRepository priceAlertRepository) {
        this.priceAlertRepository = priceAlertRepository;
    }

    @Override
    public List<PriceAlert> findAllByUser(String userId) {
        return priceAlertRepository.findByUserIdAndIsActiveTrue(userId);
    }

    @Override
    public PriceAlert createAlert(PriceAlert alert) {
        alert.setActive(true);
        return priceAlertRepository.save(alert);
    }

    @Override
    public PriceAlert findById(Long alertId) {
        Optional<PriceAlert> result = priceAlertRepository.findById(alertId);

        PriceAlert priceAlert = null;

        if (result.isPresent()) {
            priceAlert = result.get();
        } else {
            throw new RuntimeException("Did not find the alert with id - " + alertId);
        }

        return priceAlert;
    }

    @Override
    public void deleteAlert(Long alertId) {
        priceAlertRepository.findById(alertId).ifPresent(alert -> {
            alert.setActive(false);
            priceAlertRepository.save(alert);
        });
    }

    @Override
    public List<PriceAlert> checkAlerts(String productId, double currentPrice) {
        List<PriceAlert> activeAlerts = priceAlertRepository.findByProductIdAndIsActiveTrue(productId);

        return activeAlerts.stream()
                .filter(alert -> currentPrice <= alert.getTargetPrice())
                .collect(Collectors.toList());
    }
}
