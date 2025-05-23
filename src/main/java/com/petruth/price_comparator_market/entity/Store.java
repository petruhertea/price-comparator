package com.petruth.price_comparator_market.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    public Store(){

    }

    public Store(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
