package com.andrzejpe.spring.web;

import com.andrzejpe.spring.model.NewOrderForm;
import com.andrzejpe.spring.model.Order;
import com.andrzejpe.spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = {"/order"})
public class Orders {

    private OrdersService ordersService;

    @Autowired
    public Orders(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String createOrder(Model model) {
        return "order";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrder(NewOrderForm newOrderForm) {
        System.out.println("Recieved following order: " + newOrderForm);
        ordersService.createOrder(newOrderForm);
        return "order";
    }

    @RequestMapping(value = {"/orders"}, method = RequestMethod.GET)
    public String listOrders(Model model) {
        List<Order> orders = ordersService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }
}