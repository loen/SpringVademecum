package com.andrzejpe.spring.config;

import com.andrzejpe.spring.properties.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by jedrek on 2015-10-11.
 */
@Configuration
@PropertySource("app.properties")
public class RuntimePropertiesInjectionConfig {

    @Autowired
    Environment environment;

    @Bean
    public Car getCar() {
        return new Car(environment.getProperty("car.name"));
    }
}
