package com.petruth.price_comparator_market.scheduler;

import com.petruth.price_comparator_market.entity.PriceAlert;
import com.petruth.price_comparator_market.entity.Product;
import com.petruth.price_comparator_market.service.PriceAlertService;
import com.petruth.price_comparator_market.service.ProductService;
import com.petruth.price_comparator_market.util.DiscountHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertScheduler {

    private static final Logger log = LoggerFactory.getLogger(AlertScheduler.class);
    private final ProductService productService;
    private final PriceAlertService priceAlertService;
    private final DiscountHelper discountHelper;


    public AlertScheduler(ProductService productService,
                          PriceAlertService priceAlertService, DiscountHelper discountHelper) {
        this.productService = productService;
        this.priceAlertService = priceAlertService;
        this.discountHelper = discountHelper;
    }
    /*
        check for alerts every hour
        to adjust the scheduling we need to add 0 or star on a left to right order
        the order being: second, minute, hour, day of month, month, day of week
        e.g: 0 * * * * * means we are checking for alerts every minute
     */
    @Scheduled(cron = "0 0 * * * *")
    public void checkAllAlerts() {
        List<Product> allProducts = productService.findAll();

        for (Product product : allProducts) {
            double currentPrice = discountHelper.calculateDiscount(product); // poți calcula cu DiscountHelper dacă nu e deja calculat
            List<PriceAlert> triggeredAlerts = priceAlertService.checkAlerts(product.getProductId(), currentPrice);

            for (PriceAlert alert : triggeredAlerts) {
                log.info("🚨 Alert triggered for user: {}, product: {}, current price: {}, price target: {}", alert.getUserId(), product.getProductName(), currentPrice, alert.getTargetPrice());
            }
        }
    }
}
