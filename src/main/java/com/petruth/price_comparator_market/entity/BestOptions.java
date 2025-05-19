package com.petruth.price_comparator_market.entity;

public class BestOptions {
    private String productName;
    private String storeName;
    private double originalPrice;
    private double discountedPrice;
    private int quantity;
    private double totalPrice;

    public BestOptions() {

    }

    public BestOptions(String productName, String storeName, double originalPrice,
                       double discountedPrice, int quantity, double totalPrice) {
        this.productName = productName;
        this.storeName = storeName;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BestOptions{" +
                "productName='" + productName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", unitPrice=" + originalPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
