package com.petruth.price_comparator_market.rest;

import com.petruth.price_comparator_market.entity.PriceAlert;
import com.petruth.price_comparator_market.service.PriceAlertService;
import com.petruth.price_comparator_market.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PriceAlertRestController {
    private final PriceAlertService priceAlertService;
    private final ProductService productService;

    public PriceAlertRestController(PriceAlertService priceAlertService, ProductService productService) {
        this.priceAlertService = priceAlertService;
        this.productService = productService;
    }

    @GetMapping("/alerts/{userId}")
    public List<PriceAlert> getUserAlerts(@PathVariable String userId) {
        return priceAlertService.findAllByUser(userId);
    }

    @PostMapping("/alerts")
    public PriceAlert createAlert(@RequestBody @Valid PriceAlert alert) {
        if (!productService.existsByProductId(alert.getProductId())){
            throw new RuntimeException("Could not find the product with id - " + alert.getProductId());
        }
        else if (alert.getTargetPrice() < 0){
            throw new RuntimeException("The price cannot be smaller than 0");
        }

        // In case the user inserts an id in the request body, the id will be managed by the database
        alert.setId(0);

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
