package com.andrzejpe.spring.config;

import com.andrzejpe.spring.spel.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by jedrek on 2015-10-11.
 */
@Configuration
@ComponentScan(basePackages = {"com.andrzejpe.spring.spel"})
public class SpelConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "item")
    public Item getItem() {
        return new Item("new_item");
    }


}
