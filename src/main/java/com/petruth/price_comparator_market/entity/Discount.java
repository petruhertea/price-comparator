package com.petruth.price_comparator_market.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private String productId;
    /*
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    */
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "percentage_discount")
    private int percentageDiscount;

    public Discount() {

    }

    public Discount(long id, String productId, Store store, LocalDate fromDate, LocalDate toDate,
                    int percentageDiscount) {
        this.id = id;
        this.productId = productId;
        this.store = store;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.percentageDiscount = percentageDiscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /*
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

     */

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                "productId=" + productId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", percentageDiscount=" + percentageDiscount +
                '}';
    }
}
