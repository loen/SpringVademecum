package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.config.EmbeddedTestConfig;
import com.andrzejpe.spring.model.Order;
import com.mongodb.Mongo;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2016-02-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmbeddedTestConfig.class)
@ActiveProfiles(profiles = "dev")
public class MongoOrderDaoTest {

    @Inject
    Mongo mongo;

    @Test
    public void simpleMongoTest() {
        MongoTemplate template = new MongoTemplate(mongo, "orders");
        MongoOrderDao mongoOrderDao = new MongoOrderDao(template);
        Order pumba = getOrder("Pumba","Banan",5);
        mongoOrderDao.createOrder(pumba);
        Order timon = getOrder("Timon", "Ananas", 10);
        mongoOrderDao.createOrder(timon);
        Order simba = getOrder("Simba", "Stek z Antylopy", 20);
        mongoOrderDao.createOrder(simba);

        List<Order> orders = mongoOrderDao.getAllOrders();

        assertThat(orders, contains(
                hasProperty("owner", is("Pumba")),
                hasProperty("owner", is("Timon")),
                hasProperty("owner", is("Simba"))));
        assertEquals(3, orders.size());
    }

    private Order getOrder(String owner, String sku, int count) {
        Order o1 = new Order();
        o1.setOwner(owner);
        List<String> skus = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            skus.add(sku + (i + 1));
        }
        o1.setSkus(skus);
        return o1;
    }


}
