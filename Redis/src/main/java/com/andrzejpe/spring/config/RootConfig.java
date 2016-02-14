package com.andrzejpe.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import redis.clients.jedis.JedisShardInfo;

@Configuration
@ComponentScan(basePackages = "com.andrzejpe.spring", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

        @Bean
        public RedisConnectionFactory redisConnectionFactory() {
                JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
                jedisConnectionFactory.setHostName("localhost");
                jedisConnectionFactory.setPort(6379);
                jedisConnectionFactory.setShardInfo(new JedisShardInfo("localhost", 6379));
                return jedisConnectionFactory;
        }

}
