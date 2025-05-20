package com.petruth.price_comparator_market.dto;

import java.util.List;

public class StoreBasket {
    private String storeName;
    private List<BestOptions> items;
    private double totalBasketPrice;

    public StoreBasket() {

    }

    public StoreBasket(String storeName, List<BestOptions> items, double totalBasketPrice) {
        this.storeName = storeName;
        this.items = items;
        this.totalBasketPrice = totalBasketPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<BestOptions> getItems() {
        return items;
    }

    public void setItems(List<BestOptions> items) {
        this.items = items;
    }

    public double getTotalBasketPrice() {
        return totalBasketPrice;
    }

    public void setTotalBasketPrice(double totalBasketPrice) {
        this.totalBasketPrice = totalBasketPrice;
    }

    @Override
    public String toString() {
        return "StoreBasket{" +
                "storeName='" + storeName + '\'' +
                ", items=" + items +
                ", totalBasketPrice=" + totalBasketPrice +
                '}';
    }
}
