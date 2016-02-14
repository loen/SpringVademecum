package com.andrzejpe.spring.dao;

import com.andrzejpe.spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RedisOrderDaoImpl implements OrderDao {

    private RedisTemplate<String, Order> redisTemplate;

    @Autowired
    public RedisOrderDaoImpl(RedisConnectionFactory cf) {
        redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Order.class));
        redisTemplate.afterPropertiesSet();
    }

    @Override
    public List<Order> getAllOrders() {
        Set<String> keys = redisTemplate.keys("*");
        List<Order> orders = keys.stream()
                .map(k -> redisTemplate.opsForValue().get(k))
                .collect(Collectors.toList());
        return orders;
    }

    @Override
    public void createOrder(Order o) {
        redisTemplate.opsForValue().set(o.getOwner(),o);
    }
}
