package com.petruth.price_comparator_market.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "brand")
    private String brand;

    @Column(name = "package_quantity")
    private double packageQuantity;

    @Column(name = "package_unit")
    private String packageUnit;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "store", nullable = false)
    private Store store;

    @Column(name = "price_date")
    private LocalDate priceDate;

    public Product(long id, String productId, String productName, String productCategory,
                   String brand, double packageQuantity, String packageUnit, double price,
                   String currency, Store store, LocalDate priceDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.brand = brand;
        this.packageQuantity = packageQuantity;
        this.packageUnit = packageUnit;
        this.price = price;
        this.currency = currency;
        this.store = store;
        this.priceDate = priceDate;
    }

    public Product(){

    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDate priceDate) {
        this.priceDate = priceDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public double getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(double packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", brand='" + brand + '\'' +
                ", packageQuantity='" + packageQuantity + '\'' +
                ", packageUnit='" + packageUnit + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", store=" + store +
                ", priceDate=" + priceDate +
                '}';
    }
}
