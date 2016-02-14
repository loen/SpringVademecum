package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAllOrders();

    void createOrder(Order o);
}
