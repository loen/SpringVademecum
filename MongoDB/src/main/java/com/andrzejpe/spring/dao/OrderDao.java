package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.model.Order;

import java.util.List;

/**
 * Created by jedrek on 2016-02-11.
 */
public interface OrderDao {

    List<Order> getAllOrders();

    void createOrder(Order o);
}
