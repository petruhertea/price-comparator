package com.petruth.price_comparator_market.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BestOptions {
    private String productName;
    private String brand;
    private String storeName;
    private String category;
    private double originalPrice;
    private double discountedPrice;
    private double packageQuantity;
    private String packageUnit;
    private String pricePerUnit;
    // totalPrice used in best-deals endpoint and not in recommendations, as such we only include non-null values
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalPrice;

    public BestOptions() {

    }

    public BestOptions(String productName, String brand, String storeName, String category, double originalPrice,
                       double discountedPrice, int packageQuantity, String packageUnit,
                       String pricePerUnit, Double totalPrice) {
        this.productName = productName;
        this.brand = brand;
        this.storeName = storeName;
        this.category = category;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.packageQuantity = packageQuantity;
        this.packageUnit = packageUnit;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public double getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(double packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BestOptions{" +
                "productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", storeName='" + storeName + '\'' +
                ", category='" + category + '\'' +
                ", originalPrice=" + originalPrice +
                ", discountedPrice=" + discountedPrice +
                ", packageQuantity=" + packageQuantity +
                ", packageUnit='" + packageUnit + '\'' +
                ", pricePerUnit='" + pricePerUnit + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
