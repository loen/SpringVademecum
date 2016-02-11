package com.andrzejpe.spring.model;

import java.util.List;

/**
 * Created by jedrek on 2016-02-11.
 */
public class Order {
    String owner;
    List<String> skus;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getSkus() {
        return skus;
    }

    public void setSkus(List<String> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "owner='" + owner + '\'' +
                ", skus=" + skus +
                '}';
    }
}
