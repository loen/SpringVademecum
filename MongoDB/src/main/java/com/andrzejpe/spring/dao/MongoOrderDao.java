package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jedrek on 2016-02-11.
 */
@Repository
public class MongoOrderDao implements OrderDao {

    private MongoOperations mongo;

    @Autowired
    public MongoOrderDao(MongoOperations mongo) {
        this.mongo = mongo;
    }

    @Override
    public List<Order> getAllOrders() {
        return mongo.findAll(Order.class);
    }

    @Override
    public void createOrder(Order o) {
        mongo.save(o);
    }
}
