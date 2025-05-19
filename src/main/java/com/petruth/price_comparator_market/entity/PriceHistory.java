package com.petruth.price_comparator_market.entity;

import java.time.LocalDate;

public class PriceHistory {
    private String productId;
    private String productName;
    private String store;
    private String brand;
    private String category;
    private double originalPrice;
    private double discountedPrice;
    private LocalDate priceDate;

    public PriceHistory(){

    }

    public PriceHistory(String productId, String productName, String store, String brand,
                        String category, double originalPrice, LocalDate priceDate) {
        this.productId = productId;
        this.productName = productName;
        this.store = store;
        this.brand = brand;
        this.category = category;
        this.originalPrice = originalPrice;
        this.priceDate = priceDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDate priceDate) {
        this.priceDate = priceDate;
    }

    @Override
    public String toString() {
        return "PriceHistory{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", store='" + store + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", originalPrice=" + originalPrice +
                ", discountedPrice=" + discountedPrice +
                ", priceDate=" + priceDate +
                '}';
    }
}
