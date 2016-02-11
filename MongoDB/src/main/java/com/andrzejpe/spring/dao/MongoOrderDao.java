package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.model.Order;

import java.util.List;

/**
 * Created by jedrek on 2016-02-11.
 */
public class MongoOrderDao implements OrderDao {

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void createOrder(Order o) {

    }
}
