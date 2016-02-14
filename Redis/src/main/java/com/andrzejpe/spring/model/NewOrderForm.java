package com.andrzejpe.spring.model;

/**
 * Created by jedrek on 2016-02-11.
 */
public class NewOrderForm {

    String owner;
    String sku;
    Integer quantity;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NewOrderForm{" +
                "owner='" + owner + '\'' +
                ", sku='" + sku + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
