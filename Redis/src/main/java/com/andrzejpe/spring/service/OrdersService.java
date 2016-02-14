package com.andrzejpe.spring.service;

import com.andrzejpe.spring.dao.OrderDao;
import com.andrzejpe.spring.model.NewOrderForm;
import com.andrzejpe.spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jedrek on 2016-02-11.
 */

@Service
public class OrdersService {

    private OrderDao orderDao;

    @Autowired
    public OrdersService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(NewOrderForm newOrderForm) {
        Order o = prepareOrder(newOrderForm);
        orderDao.createOrder(o);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }


    private Order prepareOrder(NewOrderForm newOrderForm) {
        Order o = new Order();
        o.setOwner(newOrderForm.getOwner());
        List<String> skus = new ArrayList<>();
        for (int i = 0; i < newOrderForm.getQuantity() ; i++) {
            skus.add(newOrderForm.getSku() + "#" + (i + 1));
        }
        o.setSkus(skus);
        return o;
    }


}
