package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.entity.PriceAlert;
import com.petruth.price_comparator_market.service.PriceAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PriceAlertRestController {
    private final PriceAlertService priceAlertService;

    public PriceAlertRestController(PriceAlertService priceAlertService) {
        this.priceAlertService = priceAlertService;
    }

    @GetMapping("/alerts/{userId}")
    public List<PriceAlert> getUserAlerts(@PathVariable String userId) {
        return priceAlertService.findAllByUser(userId);
    }

    @PostMapping("/alerts")
    public PriceAlert createAlert(@RequestBody PriceAlert alert) {
        return priceAlertService.createAlert(alert);
    }

    @DeleteMapping("alerts/{alertId}")
    public String deleteAlert(@PathVariable Long alertId) {

        PriceAlert priceAlert = priceAlertService.findById(alertId);

        if (priceAlert != null){
            priceAlertService.deleteAlert(alertId);
        }
        else {
            throw new RuntimeException("Could not find the alert with id - " + alertId);
        }

        return "Alert with id " + alertId + " deleted";
    }
}
