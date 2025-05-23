package com.petruth.price_comparator_market.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "price_alert")
public class PriceAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    @NotBlank
    private String userId;

    @Column(name = "product_id")
    @NotBlank
    private String productId;

    @Column(name = "target_price")
    @Positive
    private double targetPrice;

    @Column(name = "is_active")
    private boolean isActive;

    public PriceAlert() {}

    public PriceAlert(long id, String userId, String productId, double targetPrice, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.targetPrice = targetPrice;
        this.isActive = isActive;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "PriceAlert{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", targetPrice=" + targetPrice +
                ", isActive=" + isActive +
                '}';
    }
}
